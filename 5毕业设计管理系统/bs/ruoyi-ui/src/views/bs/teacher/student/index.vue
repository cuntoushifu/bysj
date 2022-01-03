<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学号" prop="studentno">
        <el-input
          v-model="queryParams.studentno"
          placeholder="请输入学号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名" prop="studentname">
        <el-input
          v-model="queryParams.studentname"
          placeholder="请输入姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-select v-model="queryParams.sex" placeholder="请选择性别" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="选题状态" prop="selectStatus">
        <el-select v-model="queryParams.selectStatus" placeholder="请选题状态" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_topic_selectStatus"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="年级" prop="grade">
        <el-input
          v-model="queryParams.grade"
          placeholder="请输入年级"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电话" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入电话"
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
          v-hasPermi="['teacher:student:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="studentList" @selection-change="handleSelectionChange">
      <el-table-column label="学号" align="center" show-overflow-tooltip prop="studentno" />
      <el-table-column label="姓名" align="center" prop="studentname" />
      <el-table-column label="课题" align="center" show-overflow-tooltip prop="thesisName" />
      <el-table-column label="性别" align="center" prop="sex">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.sex"/>
        </template>
      </el-table-column>
      <el-table-column label="专业" align="center" prop="majorName" />
      <el-table-column label="年级" align="center" prop="grade" />
      <el-table-column label="时间" align="center" prop="lastmodifytime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastmodifytime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="电话" align="center" show-overflow-tooltip prop="phone" />
      <el-table-column label="邮箱" align="center" show-overflow-tooltip prop="email" />
      <el-table-column label="学生选题状态" align="center" prop="selectStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_topic_selectStatus" :value="scope.row.selectStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleRowData(scope.row)"
            v-hasPermi="['teacher:student:edit']"
          >查看</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit-outline"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['teacher:student:edit']"
          >审核</el-button>
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

    <!--查看对话框-->
    <el-dialog
      title="学生信息"
      :visible.sync="dialogVisible"
      width="40%">
      <el-radio-group v-model="size">
        <el-radio label="">默认</el-radio>
        <el-radio label="medium">中等</el-radio>
        <el-radio label="small">小型</el-radio>
        <el-radio label="mini">超小</el-radio>
      </el-radio-group>
      <el-descriptions class="margin-top" :column="3" :size="size" border>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            姓名
          </template>
          {{ studentdata.studentname }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            课题
          </template>
          {{ studentdata.thesisName }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            性别
          </template>
          <el-tag>{{Sexinfo(studentdata.sex)}}</el-tag>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            手机
          </template>
          {{ studentdata.phone }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-bank-card"></i>
            学号
          </template>
          {{ studentdata.studentno }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-date"></i>
            专业
          </template>
          {{ studentdata.majorName }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-date"></i>
            年级
          </template>
          {{ studentdata.grade }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-message"></i>
            邮箱
          </template>
          {{ studentdata.email }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-timer"></i>
            时间
          </template>
          {{ studentdata.lastmodifytime }}
        </el-descriptions-item>
      </el-descriptions>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
    </el-dialog>

   <!--    审核对话框-->
    <el-dialog :title="title" :visible.sync="dialogFormVisible" width="50%" append-to-body>
      <el-form :model="form" label-width="80px">
        <el-form-item label="学号">
          <el-input v-model="form.studentno" disabled></el-input>
        </el-form-item>
        <el-form-item label="学生">
          <el-input v-model="form.studentname" disabled></el-input>
        </el-form-item>
        <el-form-item label="课题">
          <el-input v-model="form.thesisName" disabled></el-input>
        </el-form-item>
        <el-form-item label="年级">
          <el-input v-model="form.grade" disabled></el-input>
        </el-form-item>
        <el-form-item label="审核" >
          <el-select v-model="form.selectStatus" clearable placeholder="请审核">
            <el-option
              v-for="dict in dict.type.sys_topic_selectStatus"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitForm()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listStudent, getStudent, delStudent, addStudent, updateStudent } from "@/api/teacher/student";

export default {
  dicts: ['sys_user_sex','sys_topic_selectStatus'],
  name: "Student",
  data() {
    return {
      // 查看对话框
      dialogVisible: false,
      // 审核对话框
      dialogFormVisible: false,
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
      // 学生表表格数据
      studentList: [],
      studentdata: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        studentno: null,
        studentname: null,
        sex: null,
        majorName: null,
        grade: null,
        inputman: null,
        lastmodifytime: null,
        phone: null,
        email: null,
        teacherNo: this.$store.state.user.name,
        selectStatus:null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        majorid: [
          { required: true, message: "专业号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /**查看对话框*/
    handleRowData(row){
      this.studentdata = row;
      this.dialogVisible = true;
    },
    /**审核对话框*/
    handleUpdataRowData(row){
      this.form = row;
      this.dialogFormVisible = true;
    },
    //性别解析
    Sexinfo(ssex){
      return this.selectDictLabel(this.dict.type.sys_user_sex, ssex);
    },
    /** 查询学生表列表 */
    getList() {
      this.loading = true;
      listStudent(this.queryParams).then(response => {
        this.studentList = response.rows;
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
        studentno: null,
        studentname: null,
        sex: null,
        majorid: null,
        grade: null,
        inputman: null,
        lastmodifytime: null,
        phone: null,
        email: null
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
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getStudent(id).then(response => {
        this.form = response.data;
        this.form.selectStatus = null;
        this.dialogFormVisible = true;
        this.title = "学生申请课题审核";
      });
    },
    /** 提交按钮 */
    submitForm() {
      updateStudent(this.form).then(response => {
        this.$modal.msgSuccess("修改成功");
        this.open = false;
        this.dialogFormVisible = false;
        this.getList();
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('teacher/student/export', {
        ...this.queryParams
      }, `student_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
