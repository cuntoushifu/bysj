<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学生" prop="studentName">
        <el-input
          v-model="queryParams.studentName"
          placeholder="请输入学生姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="成绩" prop="thesisresult">
        <el-input
          v-model="queryParams.thesisresult"
          placeholder="请输入成绩"
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
          @click="handleAdd()"
          v-hasPermi="['teacher:score:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['teacher:score:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="scoreList" @selection-change="handleSelectionChange">
      <el-table-column label="学号" align="center" prop="studentNo" />
      <el-table-column label="学生" align="center" prop="studentName" />
      <el-table-column label="成绩" align="center" prop="thesisresult" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['teacher:score:edit']"
          >修改</el-button>
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

    <!-- 添加或修改学生成绩表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="updateParams" :model="updateParams" :rules="rules" label-width="80px">
        <el-form-item label="学号" prop="studentNo">
          <el-input v-model="updateParams.studentNo" :disabled="isdisable" placeholder="请输入学生学号" />
        </el-form-item>
        <el-form-item label="学生姓名" v-show="types==='update'">
          <el-input v-model="updateParams.studentName" :disabled="isdisable" placeholder="请输入学生姓名" />
        </el-form-item>
        <el-form-item label="成绩" prop="thesisresult">
          <el-input v-model.number="updateParams.thesisresult" placeholder="请输入成绩" />
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
import { listScore, getScore, delScore, addScore, updateScore } from "@/api/teacher/score";

export default {
  name: "Score",
  data() {
    return {
      types: 'add',
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      //输入禁用
      isdisable: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 学生成绩表表格数据
      scoreList: [],
      updateParams: {
        id: 0,
        thesisResult: null,
        studentNo: null,
        studentName: null,
        teacherNo: this.$store.state.user.name
      },
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        studentName: null,
        thesisresult: null,
        teacherNo: this.$store.state.user.name
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        studentNo: [
          { required: true, message: "学号不能为空", trigger: "blur" }
        ],
        thesisresult: [
          { required: true, message: "成绩不能为空", trigger: "blur" },
          {
            validator: this.thesisresultCheck,
            trigger: 'blur'
          }
        ]
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    thesisresultCheck(rule,value,callback) {
      if(isNaN(value)){
        callback(new Error("请输入数字"));
      }else{
        if (value>100 || value<0){
          callback(new Error("请输入0-100"));
        }else {
          callback();
        }
      }
    },
    /** 查询学生成绩表列表 */
    getList() {
      this.loading = true;
      listScore(this.queryParams).then(response => {
        this.scoreList = response.rows;
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
      this.updateParams = {
        id: null,
        studentid: null,
        thesisresult: null,
        inputman: null
      };
      this.resetForm("updateParams");
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
      this.title = "添加学生成绩表";
      this.types = 'add'
      this.isdisable = false;
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      // this.reset();
      this.isdisable = true;
      this.types = 'update'
      this.updateParams.id = row.id;
      this.updateParams.thesisResult = row.thesisResult;
      this.updateParams.studentNo = row.studentNo;
      this.updateParams.studentName = row.studentName;
      this.open = true;
      this.title = "修改学生成绩";
    },
    /** 提交修改按钮 */
    submitForm() {
      this.$refs["updateParams"].validate(valid => {
        if (valid) {
          if (this.updateParams.id != null) {
            updateScore(this.updateParams).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            this.updateParams.teacherNo = this.$store.state.user.name;
            addScore(this.updateParams).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 提交添加按钮 */
    submitAddForm() {

    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除学生成绩表编号为"' + ids + '"的数据项？').then(function() {
        return delScore(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('teacher/score/export', {
        ...this.queryParams
      }, `score_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
