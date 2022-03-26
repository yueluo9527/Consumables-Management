<template xmlns="http://www.w3.org/1999/html"> 
  <div class="app-container">
    <el-card class="filter-container" shadow="never">
      <div>
        <i class="el-icon-tickets"></i>
        <span>操作日志</span>
      </div>
      <div style="float:left;margin-top: 8px">
        <el-form :inline="true" :model="listQuery" size="small" label-width="120px">
          <el-form-item label="功能模块：">
            <el-input v-model="listQuery.module" class="input-width" placeholder="功能模块" clearable
                      @keyup.enter.native="handleSearchList"></el-input>
          </el-form-item>
          <el-form-item label="操作人员：">
            <el-input v-model="listQuery.userName" class="input-width" placeholder="操作人员" clearable
                      @keyup.enter.native="handleSearchList"></el-input>
          </el-form-item>
          <el-form-item label="操作结果：">
            <el-input v-model="listQuery.result" class="input-width" placeholder="操作结果" clearable
                      @keyup.enter.native="handleSearchList"></el-input>
          </el-form-item>
        </el-form>
      </div>
      <el-button size="small" style="float:right;margin-right: 15px;margin-top: 8px"
                 type="primary" :loading="loading"
                 @click.native.prevent="handleSearchList">查询搜索
      </el-button>

      <el-button
        style="float:right;margin-right: 10px;margin-top: 8px"
        @click="handleResetSearch()"
        size="small">重置
      </el-button>
    </el-card>

    <div class="table-container">
      <el-table ref="operationLogTable"
                :data="list"
                :row-class-name="rowClassName"
                tooltip-effect="light"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column prop="newId" align="center" label="序号" width="60"></el-table-column>
        <el-table-column label="功能模块" align="center">
          <template slot-scope="scope">{{ scope.row.module }}</template>
        </el-table-column>
        <el-table-column label="操作内容" align="center">
          <template slot-scope="scope">{{ scope.row.operaLog }}</template>
        </el-table-column>
        <el-table-column label="操作对象ID" align="center">
          <template slot-scope="scope">{{ scope.row.operaId }}</template>
        </el-table-column>
        <el-table-column label="请求方式" align="center">
          <template slot-scope="scope">{{ scope.row.method }}</template>
        </el-table-column>
        <el-table-column label="操作人员" align="center">
          <template slot-scope="scope">{{ scope.row.userName }}</template>
        </el-table-column>
        <el-table-column label="主机" align="center">
          <template slot-scope="scope">{{ scope.row.ip }}</template>
        </el-table-column>
        <el-table-column label="请求参数" align="center" show-overflow-tooltip>
          <template slot-scope="scope">{{ scope.row.operaParams }}</template>
        </el-table-column>
        <el-table-column label="操作结果" align="center">
          <template slot-scope="scope">{{ scope.row.result }}</template>
        </el-table-column>
        <el-table-column label="操作日期" align="center">
          <template slot-scope="scope">{{ scope.row.createTime | formatDateTime }}</template>
        </el-table-column>
      </el-table>
    </div>
    <el-button style="margin-top: 20px" size="small" @click="back()">返回</el-button>
    <div class="pagination-container">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        layout="total, sizes,prev, pager, next,jumper"
        :current-page.sync="listQuery.pageNum"
        :page-size="listQuery.pageSize"
        :page-sizes="[50,100,200]"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
import {searchList} from '@/api/operationLog';
import {formatDate} from '@/utils/date';
import {getCookie} from "../../../utils/support";

const defaultListQuery = {
  pageNum: 1,
  pageSize: 50,
  keyword: null,
  module: null,
  userName: null,
  result: null,
  username: getCookie('username')
};
export default {
  name: 'OperationLogList',
  data() {
    return {
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      loading: false,
      listLoading: false,
    }
  },
  created() {
    this.getSearchList();
  },
  filters: {
    formatDateTime(time) {
      if (time == null || time === '') {
        return 'N/A';
      }
      let date = new Date(time);
      return formatDate(date, 'yyyy-MM-dd hh:mm:ss')
    }
  },
  methods: {
    rowClassName({row, rowIndex}) {
      //把每一行的索引放进row.id
      row.newId = (this.listQuery.pageSize * (this.listQuery.pageNum - 1)) + rowIndex + 1;
    },
    back() {
      if (window.history.length <= 1) {
        this.$router.push({path: '/'})
        return false
      } else {
        this.$router.go(-1)
      }
    },
    handleResetSearch() {
      this.listQuery = Object.assign({}, defaultListQuery);
      this.getSearchList();
    },
    handleSearchList() {
      this.listQuery.pageNum = 1;
      this.getSearchList();
    },
    handleSizeChange(val) {
      this.listQuery.pageNum = 1;
      this.listQuery.pageSize = val;
      this.getSearchList();
    },
    handleCurrentChange(val) {
      this.listQuery.pageNum = val;
      this.getSearchList();
    },
    getSearchList() {
      this.listLoading = true;
      searchList(this.listQuery).then(response => {
        this.listLoading = false;
        this.list = response.data.list;
        this.total = response.data.total;
      });
    },
  }
}
</script>
<style>
.input-width {
  width: 160px;
}
</style>

