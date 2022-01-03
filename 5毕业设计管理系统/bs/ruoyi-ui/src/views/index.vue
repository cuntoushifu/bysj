<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
        <h1>Welcome</h1>
        <p>欢迎访问毕业设计管理系统</p>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>公告</h2>
        <el-collapse v-model="activeName" accordion>
          <el-collapse-item :name="item.noticeId"
                            v-for="item in noticeList" :key="item.noticeId">
            <template slot="title">
              <dict-tag class="tab" :options="dict.type.sys_notice_type" :value="item.noticeType"/>
              {{ item.noticeTitle }}
            </template>
            <div v-html="item.noticeContent"></div>
            <div class="creater">{{item.createBy}}-{{item.createTime}}</div>
          </el-collapse-item>
        </el-collapse>
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="12">
            <h2>技术选型</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <h4>后端技术</h4>
            <ul>
              <li>SpringBoot</li>
              <li>Spring Security</li>
              <li>JWT</li>
              <li>MyBatis</li>
            </ul>
          </el-col>
          <el-col :span="6">
            <h4>前端技术</h4>
            <ul>
              <li>Vue</li>
              <li>Vuex</li>
              <li>Element-ui</li>
              <li>Axios</li>
              <li>Sass</li>
              <li>...</li>
            </ul>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider />
<!--    <el-row :gutter="20">-->
<!--      <el-col :xs="24" :sm="24" :md="12" :lg="8">-->
<!--        <el-card class="update-log">-->
<!--          <h2>公告</h2>-->
<!--        </el-card>-->
<!--      </el-col>-->
<!--      <el-col :xs="24" :sm="24" :md="12" :lg="8">-->
<!--        <el-card class="update-log">-->
<!--          <h2>通知</h2>-->
<!--        </el-card>-->
<!--      </el-col>-->
<!--    </el-row>-->
  </div>
</template>

<script>
import {listNotice} from "@/api/system/notice";
import { checkPermi, checkRole } from "@/utils/permission"; // 权限判断函数

export default {
  name: "Index",
  dicts: ['sys_notice_type'],
  data() {
    return {
      // 版本号
      version: "3.7.0",
      // 总条数
      total: 0,
      // 公告表格数据
      noticeList: [],
      // 遮罩层
      loading: true,
      activeName: '1'
    };
  },
  created() {
    this.getList();
  },
  methods: {
    checkPermi,
    checkRole,
    goTarget(href) {
      window.open(href, "_blank");
    },
    /** 查询公告列表 */
    getList() {
      this.loading = true;
      listNotice(this.queryParams).then(response => {
        this.noticeList = response.rows.reverse();
        this.total = response.total;
        this.loading = false;
      });
    },

  },
};
</script>

<style scoped lang="scss">
.creater{
  text-align: right;
}
.tab{
  margin-right: 5px;
}
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

