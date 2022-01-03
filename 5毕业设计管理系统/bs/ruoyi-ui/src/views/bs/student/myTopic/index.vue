<template>
  <div class="app-container">
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['student:myTopic:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="myTopicList">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="课题" align="center" prop="thesisName" />
      <el-table-column label="学号" align="center" prop="studentNo" />
      <el-table-column label="学生" align="center" prop="studentName" />
      <el-table-column label="教师" align="center" prop="teacherName" />
      <el-table-column label="选题时间" align="center" prop="selecttime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.selecttime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="课题状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_topic_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="审题状态" align="center" prop="selectStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_topic_selectStatus" :value="scope.row.selectStatus"/>
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
  </div>
</template>

<script>
import { listMyTopic, getMyTopic, delMyTopic, addMyTopic, updateMyTopic } from "@/api/student/myTopic";
import {getUserProfile} from "@/api/system/user";

export default {
  dicts: ['sys_topic_status','sys_topic_selectStatus'],
  name: "MyTopic",
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
      // 选题信息表表格数据
      myTopicList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        thesisid: null,
        studentNo: null,
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
    /** 拿到用户名 */
    getList() {
      this.loading = true;
      /** 获取当前登陆用户名*/
      this.queryParams.studentNo = this.$store.state.user.name;
      listMyTopic(this.queryParams).then(response => {
        this.myTopicList = response.rows;
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
    /** 导出按钮操作 */
    handleExport() {
      this.download('student/myTopic/export', {
        ...this.queryParams
      }, `myTopic_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
