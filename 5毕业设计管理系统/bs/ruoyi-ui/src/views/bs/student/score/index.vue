<template>
  <div class="app-container">
<!--    <el-table v-loading="loading" :data="scoreList" @selection-change="handleSelectionChange">-->
<!--      <el-table-column type="selection" width="55" align="center" />-->
<!--      <el-table-column label="编号" align="center" prop="id" />-->
<!--      <el-table-column label="姓名" align="center" prop="studentName" />-->
<!--      <el-table-column label="成绩" align="center" prop="thesisresult" />-->
<!--    </el-table>-->

<!--    <pagination-->
<!--      v-show="total>0"-->
<!--      :total="total"-->
<!--      :page.sync="queryParams.pageNum"-->
<!--      :limit.sync="queryParams.pageSize"-->
<!--      @pagination="getList"-->
<!--    />-->

    <div class="myscore">
      <span class="fontStyle">{{thesisresult}}分</span>
    </div>
  </div>
</template>

<script>
import { listScore, getScore, delScore, addScore, updateScore } from "@/api/student/score";

export default {
  name: "Score",
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
      // 学生成绩表表格数据
      scoreList: [],
      thesisresult: 0,
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        studentNo: null,
        thesisresult: null,
        inputman: null
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询学生成绩表列表 */
    getList() {
      this.loading = true;
      /** 获取当前登陆用户名*/
      this.queryParams.studentNo = this.$store.state.user.name;
      listScore(this.queryParams).then(response => {
        this.scoreList = response.rows;
        this.total = response.total;
        this.loading = false;
        this.thesisresult = this.scoreList[0].thesisresult
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
        thesisresult: null,
        inputman: null
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

    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getScore(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学生成绩表";
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('student/score/export', {
        ...this.queryParams
      }, `score_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

<style>
.myscore{
  height: 60vh;
  width: 90vw;
  background: url("../../../../assets/images/bg_score.png") no-repeat;
  background-size: contain;
}
.fontStyle{
  display: block;
  height: 20vh;
  width: 20vw;
  font-family: "华文行楷";
  /*font-weight: 700;*/
  font-size: 3rem;
  color: red;
  transform: translate(80%,50%);
}

</style>
