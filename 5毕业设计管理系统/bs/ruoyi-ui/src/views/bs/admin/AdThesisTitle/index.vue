<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="课题" prop="thesisname">
        <el-input
          v-model="queryParams.thesisname"
          placeholder="请输入课题"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="教师" prop="teacherName">
        <el-input
          v-model="queryParams.teacherName"
          placeholder="请输入教师姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提交时间" prop="submittime">
        <el-date-picker clearable size="small"
          v-model="queryParams.submittime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择提交时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="课题审核" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择课题状态" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_topic_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="难度" prop="nandu">
        <el-input
          v-model="queryParams.nandu"
          placeholder="请输入难度"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="量" prop="liang">
        <el-input
          v-model="queryParams.liang"
          placeholder="请输入量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类型" prop="leixing">
        <el-input
          v-model="queryParams.leixing"
          placeholder="请输入类型"
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
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasRole="['common']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasRole="['common']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasRole="['common']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasRole="['common']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="AdThesisTitleList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="课题" align="center" show-overflow-tooltip prop="thesisname" />
      <el-table-column label="教师" align="center" prop="teacherName" />
      <el-table-column label="提交时间" align="center" prop="submittime" width="180">
      </el-table-column>
      <el-table-column label="课题审核" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_topic_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="创建者" align="center" prop="inputman" />
      <el-table-column label="难度" align="center" prop="nandu" />
      <el-table-column label="量" align="center" prop="liang" />
      <el-table-column label="类型" align="center" prop="leixing" />
      <el-table-column label="描述" align="center" show-overflow-tooltip prop="descriptions" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['admin:AdThesisTitle:edit']"
          >审核</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:AdThesisTitle:remove']"
          >删除</el-button>
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

    <!-- 添加或修改教师提交课题表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="课题" prop="thesisname">
          <el-input v-model="form.thesisname" placeholder="请输入课题" />
        </el-form-item>
        <el-form-item label="教师" prop="teacherName">
          <el-input v-model="form.teacherName" placeholder="请输入教师" />
        </el-form-item>
        <el-form-item label="提交时间" prop="submittime">
          <el-date-picker clearable size="small"
            v-model="form.submittime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择提交时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="课题审核">
          <el-select v-model="form.status" placeholder="请选择状态" clearable size="small">
            <el-option
              v-for="dict in dict.type.sys_topic_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="难度" prop="nandu">
          <el-input v-model="form.nandu" placeholder="请输入难度" />
        </el-form-item>
        <el-form-item label="量" prop="liang">
          <el-input v-model="form.liang" placeholder="请输入量" />
        </el-form-item>
        <el-form-item label="课题类型" prop="tofrom">
          <el-input v-model="form.tofrom" placeholder="请输入课题类型" />
        </el-form-item>
        <el-form-item label="类型" prop="leixing">
          <el-input v-model="form.leixing" placeholder="请输入类型" />
        </el-form-item>
        <el-form-item label="描述" prop="descriptions">
          <el-input v-model="form.descriptions" placeholder="请输入描述" />
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
import { listAdThesisTitle, getAdThesisTitle, delAdThesisTitle, addAdThesisTitle, updateAdThesisTitle } from "@/api/admin/AdThesisTitle";

export default {
  dicts: ['sys_topic_status'],
  name: "AdThesisTitle",
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
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 教师提交课题表表格数据
      AdThesisTitleList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        teacherName: null,
        thesisName: null,
        status: null,
        nandu: null,
        liang: null,
        tofrom: null,
        leixing: null,
        studentNo: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        teacherid: [
          { required: true, message: "教师号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询教师提交课题表列表 */
    getList() {
      this.loading = true;
      listAdThesisTitle(this.queryParams).then(response => {
        this.AdThesisTitleList = response.rows;
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
      this.form = {
        id: null,
        thesisname: null,
        teacherid: null,
        submittime: null,
        status: 0,
        inputman: null,
        nandu: null,
        liang: null,
        tofrom: null,
        leixing: null,
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加教师提交课题表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      const id = row.id || this.ids
      getAdThesisTitle(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.form.status = null;
        this.title = "修改教师课题";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAdThesisTitle(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAdThesisTitle(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除教师提交课题表编号为"' + ids + '"的数据项？').then(function() {
        return delAdThesisTitle(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/AdThesisTitle/export', {
        ...this.queryParams
      }, `AdThesisTitle_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
