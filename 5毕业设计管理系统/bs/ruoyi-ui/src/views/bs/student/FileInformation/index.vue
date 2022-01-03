<template>
  <div class="app-container">

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['student:doubt:add']"
        >新增</el-button>
      </el-col>
    </el-row>
    <el-table v-loading="loading" :data="FileInformationList" @selection-change="handleSelectionChange">
      <el-table-column label="学号" align="center" prop="studentNo" />
      <el-table-column label="课题" align="center" prop="thesistext" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_file_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="描述" align="center" prop="description" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-upload"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['student:FileInformation:edit']"
          >重新上传</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-download"
            @click="handleDownload(scope.row)"
          >下载</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改文档提交表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form :model="forms" ref="forms" :rules="rules" label-width="80px">
        <el-form-item label="学号">
          <el-input v-text="userNo" disabled />
        </el-form-item>
        <el-form-item label="课题">
          <el-upload
            ref="upload"
            :limit="1"
            accept=".zip,.doc,.docx"
            :action="upload.url"
            :headers="upload.headers"
            :file-list="upload.fileList"
            :on-progress="handleFileUploadProgress"
            :on-success="handleFileSuccess"
            :before-upload="beforeFileUpload"
            :auto-upload="false">
            <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
            <el-button style="margin-left: 10px;" size="small" type="success" :loading="upload.isUploading" @click="submitUpload">上传到服务器</el-button>
            <div slot="tip" class="el-upload__tip">只能上传zip/doc/docx文件，且不超过100Mb</div>
          </el-upload>
        </el-form-item>
        <el-form-item label="描述" prop="descriptions">
          <el-input v-model="forms.description" placeholder="请输入描述" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listFileInformation, getFileInformation, delFileInformation, addFileInformation, updateFileInformation } from "@/api/student/FileInformation";
import { getToken } from "@/utils/auth";

export default {
  dicts: ['sys_file_status'],
  name: "FileInformation",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      //当前用户名
      userNo: this.$store.state.user.name,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 文档提交表表格数据
      FileInformationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        studentNo: null,
        thesistext: null,
        status: null,
        description: null
      },
      // 上传参数
      upload: {
        // 是否禁用上传
        isUploading: false,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/common/upload",
        // 上传的文件列表
        fileList: []
      },
      // 表单参数
      forms: {
        description: '',
        thesistext: ''
      },
      // 表单校验
      rules: {
        description:[
          { required: true, message: "课题路径不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询文档提交表列表 */
    getList() {
      this.loading = true;
      /** 获取当前登陆用户名*/
      this.queryParams.studentNo = this.$store.state.user.name;
      listFileInformation(this.queryParams).then(response => {
        this.FileInformationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.forms = {
        id: null,
        studentid: null,
        thesistext: null,
        status: 0,
        description: null
      };
      this.resetForm("forms");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加文档提交表";
      this.upload.fileList = [];
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.forms.id = row.id;
      this.open = true;
      this.title = "修改文档提交表";
      console.log(row.id)
      /** 修改{ name: this.userNo, url: this.forms.thesistext } */
      this.upload.fileList = [];
    },
    /** 文件上传*/
    beforeFileUpload(file) {
      const isLt2M = file.size / 1024 / 1024 < 100;
      if (!isLt2M) {
        this.$message.error('上传文件大小不能超过 100MB!');
      }
      return isLt2M;
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["forms"].validate(valid => {
        if (valid) {
          if (this.forms.id != null) {
            updateFileInformation(this.forms).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            this.forms.studentNo = this.$store.state.user.name;
            addFileInformation(this.forms).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 文件下载处理*/
    handleDownload(row) {
      var name = row.studentName;
      var url = row.thesistext;
      var suffix = url.substring(url.lastIndexOf("."), url.length);
      const a = document.createElement('a')
      a.setAttribute('download', name + suffix)
      a.setAttribute('target', '_blank')
      a.setAttribute('href', url)
      a.click()
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('student/FileInformation/export', {
        ...this.queryParams
      }, `FileInformation_${new Date().getTime()}.xlsx`)
    },

    // 文件提交处理
    submitUpload() {
      /**
       * 先查询系统，再上传
       */
      // getFileInformation(this.queryParams.studentNo).then(response => {
      //   console.log(response);
      //   this.$modal.msgSuccess("新增成功");
      // });
      this.$refs.upload.submit();
    },
// 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
// 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      console.log("******")
      this.upload.isUploading = false;
      this.forms.thesistext = response.url;
      this.$message.success("上传成功");
    }
  }
};
</script>
