<template> 
  <div class="app-container">
    <el-card class="filter-container" shadow="never">
      <div>
        <i class="el-icon-tickets"></i>
        <span>领用列表</span>
      </div>

      <el-button size="small" style="float:right;margin-right: 15px"
                 type="primary" :loading="loading"
                 @click.native.prevent="handleSearchList">
        查询搜索
      </el-button>
      <el-button
        style="float:right;margin-right: 10px"
        @click="handleResetSearch()"
        size="small">
        重置
      </el-button>
      <div style="float:right">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item>
            <el-input v-model="listQuery.keyword" class="input-width" placeholder="申请单号/申请人员"
                      @keyup.enter.native="handleSearchList"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <div class="table-container">
      <el-table ref="collectTable"
                :data="list"
                :row-class-name="rowClassName"
                max-height="550"
                stripe
                :default-sort="{scope: 'scope.row.collectDay', collect: 'descending'}"
                style="width: 100%;"
                @selection-change="handleSelectionChange"
                v-loading="listLoading" border>
        <el-table-column prop="newId" align="center" label="序号" width="60"></el-table-column>
        <el-table-column label="申请编号" min-width="150%" align="center">
          <template slot-scope="scope">{{ scope.row.collectNo }}</template>
        </el-table-column>
        <el-table-column label="申请日" align="center">
          <template slot-scope="scope">{{ scope.row.collectDay | formatCollectTime }}</template>
        </el-table-column>
        <el-table-column label="申请人" align="center">
          <template slot-scope="scope">{{ scope.row.createName }}</template>
        </el-table-column>
        <el-table-column label="所属科室库" align="center">
          <template slot-scope="scope">{{ scope.row.branch }}</template>
        </el-table-column>
        <el-table-column label="状态" align="center">
          <template slot-scope="scope">
            {{ scope.row.collectStatus ? statusData[(scope.row.collectStatus)].label : '草稿' }}
          </template>
        </el-table-column>
        <el-table-column label="描述" align="center">
          <template slot-scope="scope">{{ scope.row.collectDescribe }}</template>
        </el-table-column>
        <el-table-column label="操作" width="180" align="center">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              @click="handleViewCollect(scope.$index, scope.row)"
              v-show="scope.row.collectStatus==1">查看
            </el-button>
            <el-button
              size="mini"
              type="primary"
              icon="el-icon-edit"
              @click="handleViewCollect(scope.$index, scope.row)"
              v-show="scope.row.collectStatus==0">编辑
            </el-button>
            <el-button
              size="mini"
              type="danger"
              v-show="roleId == 3 || roleId == 1"
              @click="handleDeleteCollect(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!--    <div class="batch-operate-container">
          <el-select
            size="small"
            v-model="operateType" placeholder="批量操作">
            <el-option
              v-for="item in operateOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
          <el-button
            style="margin-left: 20px"
            class="search-button"
            @click="handleBatchOperate()"
            type="primary"
            size="small">确定
          </el-button>
        </div>-->
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
import {deleteCollect, fetchList} from '@/api/collect'
import {formatDate} from '@/utils/date';
import {deleteCollectDetail} from "@/api/collectDetail";
import {getCookie} from '@/utils/support';
import {getRole} from '@/api/order';

const defaultListQuery = {
  pageNum: 1,
  pageSize: 50,
  keyword: null,
  applyType: 1,
  username: getCookie("username"),
};
export default {
  name: "collectList",
  data() {
    return {
      listQuery: Object.assign({}, defaultListQuery),
      loading: false,
      listLoading: false,
      list: null,
      total: null,
      operateType: null,
      multipleSelection: [],
      roleId: 0,

      //申请单状态
      statusData: [
        {
          label: '草稿',
          value: 0
        },
        {
          label: '已提交',
          value: 1
        }
      ],
      //申请单操作
      operateOptions: [
        {
          label: "批量删除",
          value: 2
        }
      ],
    }
  },
  created() {
    this.getList();
    this.getRole();
  },
  filters: {
    formatCollectTime(time) {
      if (time == null || time === '') {
        return 'N/A';
      }
      let date = new Date(time);
      return formatDate(date, 'yyyy-MM-dd')
    }
  },
  methods: {
    rowClassName({row, rowIndex}) {
      //把每一行的索引放进row.id
      row.newId = (this.listQuery.pageSize * (this.listQuery.pageNum - 1) ) + rowIndex + 1;
    },
    back() {
      if (window.history.length <= 1) {
        this.$router.push({path: '/'})
        return false
      } else {
        this.$router.go(-1)
      }
    },
    getRole() {
      getRole(this.listQuery.username).then(response => {
        this.roleId = response.data;
      })
    },
    handleResetSearch() {
      this.listQuery = Object.assign({}, defaultListQuery);
    },
    handleSearchList() {
      this.listQuery.pageNum = 1;
      this.getList();
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleViewCollect(index, row) {
      this.$router.push({
        path: '/cms/collectDetail',
        query: {collectNo: row.collectNo, collectStatus: row.collectStatus}
      })
    },
    handleDeleteCollect(index, row) {
      let ids = [];
      let collectNos = [];
      ids.push(row.id);
      collectNos.push(row.collectNo);
      this.deleteCollect(ids, collectNos);
    },
    handleBatchOperate() {
      if (this.multipleSelection == null || this.multipleSelection.length < 1) {
        this.$message({
          message: '请选择要操作的申请单',
          type: 'warning',
          duration: 1000
        });
        return;
      }
      if (this.operateType === 2) {
        //删除申请单
        let ids = [];
        let collectNos = [];
        for (let i = 0; i < this.multipleSelection.length; i++) {
          ids.push(this.multipleSelection[i].id);
          collectNos.push(this.multipleSelection[i].collectNo);
        }
        this.deleteCollect(ids, collectNos);
      }
    },
    handleSizeChange(val) {
      this.listQuery.pageNum = 1;
      this.listQuery.pageSize = val;
      this.getList();
    },
    handleCurrentChange(val) {
      this.listQuery.pageNum = val;
      this.getList();
    },
    getList() {
      this.listLoading = true;
      fetchList(this.listQuery).then(response => {
        this.listLoading = false;
        this.list = response.data.list;
        this.total = response.data.total;
      });
    },
    deleteCollect(ids, collectNos) {
      this.$confirm('是否要进行该删除操作?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let params_id = new URLSearchParams();
        params_id.append("ids", ids);
        let params_collectNo = new URLSearchParams();
        params_collectNo.append("collectNos", collectNos);

        deleteCollect(params_id).then(response => {
          this.$message({
            message: '删除成功！',
            type: 'success',
            duration: 1000
          });
          this.getList();
        });
        deleteCollectDetail(params_collectNo);
      })
    },
  }
}
</script>
<style scoped>
.input-width {
  width: 203px;
}
</style>


