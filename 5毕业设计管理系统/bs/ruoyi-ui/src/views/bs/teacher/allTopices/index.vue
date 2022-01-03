<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="课题" prop="thesisid">
        <el-input
          v-model="queryParams.thesisName"
          placeholder="请输入课题名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['teacher:allTopices:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="allTopicesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="课题名" align="center" prop="thesisName" />
      <el-table-column label="教师" align="center" prop="teacherName" />
      <el-table-column label="审核状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_topic_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="难度" align="center" prop="nandu" />
      <el-table-column label="量" align="center" prop="liang" />
      <el-table-column label="课题类型" align="center" prop="tofrom" />
      <el-table-column label="系统类型" align="center" prop="leixing" />
      <el-table-column label="描述" show-overflow-tooltip align="center" prop="descriptions" />
      <el-table-column label="学号" align="center" prop="studentNo" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="dialoginfo(scope.row)"
          >查看</el-button>
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
    <!-- 对话框-->
    <el-dialog
      title="课题信息"
      :visible.sync="dialogVisible"
      width="40%">
      <el-radio-group v-model="size">
        <el-radio label="">默认</el-radio>
        <el-radio label="medium">中等</el-radio>
        <el-radio label="small">小型</el-radio>
        <el-radio label="mini">超小</el-radio>
      </el-radio-group>
      <el-descriptions class="margin-top" :column="2" :size="size" border>
        <el-descriptions-item>
          <template slot="label">
            课题名
          </template>
          {{ topicesinfo.thesisName }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            教师
          </template>
          {{ topicesinfo.teacherName }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            课题类型
          </template>
          {{ topicesinfo.tofrom }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            难度
          </template>
          {{topicesinfo.nandu}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            系统类型
          </template>
          {{ topicesinfo.leixing }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            量
          </template>
          {{topicesinfo.liang}}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            审核状态
          </template>
          <el-tag>{{topiceStatus(topicesinfo.status)}}</el-tag>

        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            学生学号
          </template>
          {{ topicesinfo.studentNo }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            课题描述
          </template>
          {{ topicesinfo.descriptions }}
        </el-descriptions-item>
      </el-descriptions>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
import { listAllTopices, getAllTopices, delAllTopices, addAllTopices, updateAllTopices } from "@/api/teacher/allTopices";

export default {
  dicts: ['sys_topic_status'],
  name: "AllTopices",
  data() {
    return {
      dialogVisible: false,
      size: '',
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
      // 选题信息表表格数据
      allTopicesList: [],
      topicesinfo: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        thesisName: null,
        studentid: null,
        selecttime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        thesisid: [
          { required: true, message: "课题号不能为空", trigger: "blur" }
        ],
        studentid: [
          { required: true, message: "学号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询选题信息表列表 */
    getList() {
      this.loading = true;
      listAllTopices(this.queryParams).then(response => {
        this.allTopicesList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    //字典状态解析
    topiceStatus(row){
      return this.selectDictLabel(this.dict.type.sys_topic_status, row);
    },
    //对话框
    dialoginfo(row){
      this.topicesinfo = row;
      console.log(row)
      this.dialogVisible = true;
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
        thesisid: null,
        studentid: null,
        selecttime: null
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加选题信息表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAllTopices(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改选题信息表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAllTopices(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAllTopices(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除选题信息表编号为"' + ids + '"的数据项？').then(function() {
        return delAllTopices(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('teacher/allTopices/export', {
        ...this.queryParams
      }, `allTopices_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
