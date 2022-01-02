<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学号" prop="studentNo">
        <el-input
          v-model="queryParams.studentNo"
          placeholder="请输入学号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_topic_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['teacher:fileInformation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="fileInformationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="学号" align="center" prop="studentNo" />
      <el-table-column label="学生" align="center" prop="studentName" />
      <el-table-column label="课题" align="center" prop="thesisName" />
      <el-table-column label="文件路径" align="center" show-overflow-tooltip prop="thesistext" />
      <el-table-column label="状态" align="center" prop="status">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.sys_topic_status" :value="scope.row.status"/>
          </template>
      </el-table-column>
      <el-table-column label="描述" align="center" show-overflow-tooltip prop="description" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleExamine(scope.row)"
            v-hasPermi="['teacher:fileInformation:edit']"
          >审核</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-download"
            @click="handleDownload(scope.row)"
            v-hasPermi="['teacher:fileInformation:remove']"
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

    <!-- 修改审核状态对话框 -->
    <el-dialog title="学生文件审核" :visible.sync="dialogFormVisible" width="50%" append-to-body>
      审核状态：
      <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
        <el-option
          v-for="dict in dict.type.sys_topic_status"
          :key="dict.value"
          :label="dict.label"
          :value="dict.value"
        />
      </el-select>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitForm()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listFileInformation, getFileInformation, delFileInformation, addFileInformation, updateFileInformation } from "@/api/teacher/fileInformation";

export default {
  dicts: ['sys_topic_status'],
  name: "FileInformation",
  data() {
    return {
      dialogFormVisible: false,
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 文档提交表表格数据
      fileInformationList: [],
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
        description: null,
        teacherNo: this.$store.state.user.name
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        studentNo: [
          { required: true, message: "学号不能为空", trigger: "blur" }
        ],
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
      listFileInformation(this.queryParams).then(response => {
        this.fileInformationList = response.rows;
        this.total = response.total;
        this.loading = false;
        console.log(response.rows)
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        studentid: null,
        thesistext: null,
        status: 0,
        description: null
      };
      this.resetForm("form");
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
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    //修改审核状态对话框
    handleExamine(row){
      this.queryParams.status = row.status;
      this.queryParams.id = row.id;
      this.queryParams.status = null;
      this.dialogFormVisible = true;
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getFileInformation(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改文档提交表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      console.log(this.queryParams)
      this.dialogFormVisible = false
      updateFileInformation(this.queryParams).then(response => {
        this.$modal.msgSuccess("修改成功");
        this.open = false;
        this.getList();
      });
    },
    /** 文件下载处理*/
    handleDownload(row) {
      console.log(row)
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
      this.download('teacher/fileInformation/export', {
        ...this.queryParams
      }, `fileInformation_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
