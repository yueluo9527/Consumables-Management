<template> 
  <div class="app-container">
    <el-card class="filter-container" shadow="never">

      <div>
        <i class="el-icon-tickets"></i>
        <span>退货列表</span>
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
            <el-input v-model="listQuery.keyword" class="input-width" placeholder="退货单号/制单人员"
                      @keyup.enter.native="handleSearchList"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>

    <div class="table-container">
      <el-table ref="refundTable"
                :data="list"
                :row-class-name="rowClassName"
                max-height="550"
                stripe
                :default-sort="{scope: 'scope.row.orderDay', order: 'descending'}"
                style="width: 100%;"
                @selection-change="handleSelectionChange"
                v-loading="listLoading" border>
        <el-table-column prop="newId" align="center" label="序号" width="60"></el-table-column>

        <el-table-column label="退货单编号" min-width="130%" align="center">
          <template slot-scope="scope">{{ scope.row.refundCode }}</template>
        </el-table-column>
        <el-table-column label="数量" align="center">
          <template slot-scope="scope">{{ scope.row.quantity }}</template>
        </el-table-column>
        <el-table-column label="金额" align="center">
          <template slot-scope="scope">¥ {{ scope.row.total }}</template>
        </el-table-column>
        <el-table-column label="供货商" align="center">
          <template slot-scope="scope">{{ scope.row.supplierShortName }}</template>
        </el-table-column>
        <el-table-column label="制单人员" align="center">
          <template slot-scope="scope">{{ scope.row.createBy }}</template>
        </el-table-column>
        <el-table-column label="创建时间" min-width="100%" align="center">
          <template slot-scope="scope">{{ scope.row.createTime | formatRefundTime }}</template>
        </el-table-column>
        <el-table-column label="备注" align="center">
          <template slot-scope="scope">{{ scope.row.remark }}</template>
        </el-table-column>

        <el-table-column label="操作" width="180" align="center">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              @click="handleViewRefund(scope.$index, scope.row)">查看
            </el-button>

            <el-button
              size="mini"
              type="danger"
              @click="handleDeleteRefund(scope.$index, scope.row)">删除
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
import {deleteRefund, fetchList} from '@/api/refund'
import {formatDate} from '@/utils/date';
import {deleteRefundDetail} from "@/api/refundDetail";
import {getCookie} from '@/utils/support';

const defaultListQuery = {
  pageNum: 1,
  pageSize: 50,
  keyword: null,
  applyType: null,
  refundType: 2,
  username: getCookie("username"),
};
export default {
  name: "refundList",
  data() {
    return {
      listQuery: Object.assign({}, defaultListQuery),
      loading: false,
      listLoading: false,
      list: null,
      total: null,
      operateType: null,
      multipleSelection: [],
      downloadLoading: false,
      refundDetail: [],
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
  },
  filters: {
    formatRefundTime(time) {
      if (time == null || time === '') {
        return 'N/A';
      }
      let date = new Date(time);
      return formatDate(date, 'yyyy-MM-dd hh:mm:ss');
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
    handleViewRefund(index, row) {
      this.$router.push({
        path: '/rms/refundDetail',
        query: {refundCode: row.refundCode}
      })
    },
    handleDeleteRefund(index, row) {
      let ids = [];
      let refundCodes = [];
      ids.push(row.id);
      refundCodes.push(row.refundCode);
      this.deleteRefund(ids, refundCodes);
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
        let refundCodes = [];
        for (let i = 0; i < this.multipleSelection.length; i++) {
          ids.push(this.multipleSelection[i].id);
          refundCodes.push(this.multipleSelection[i].refundCode);
        }
        this.deleteRefund(ids, refundCodes);
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
    deleteRefund(ids, refundCodes) {
      this.$confirm('是否要进行该删除操作?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let params_id = new URLSearchParams();
        params_id.append("ids", ids);
        let params_refundCode = new URLSearchParams();
        params_refundCode.append("refundCodes", refundCodes);

        deleteRefund(params_id).then(response => {
          this.$message({
            message: '删除成功！',
            type: 'success',
            duration: 1000
          });
          this.getList();
        });
        //删除详情表
        deleteRefundDetail(params_refundCode);
        //删除详细表
        //deleteRefundDetailItem(params_refundCode);
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


