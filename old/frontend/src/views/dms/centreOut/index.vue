<template> 
  <div class="app-container">
    <el-card class="filter-container" shadow="never">
      <div>
        <i class="el-icon-tickets"></i>
        <span>出库列表</span>
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
            <el-input v-model="listQuery.keyword" class="input-width" placeholder="出库编号"
                      @keyup.enter.native="handleSearchList"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>

    <div class="table-container">
      <el-table ref="CentreOutTable"
                :data="list"
                :row-class-name="rowClassName"
                style="width: 100%;"
                max-height="550"
                v-loading="listLoading" border>
        <el-table-column prop="newId" align="center" label="序号" width="60"></el-table-column>

        <el-table-column label="出库单号" width="250" align="center">
          <template slot-scope="scope">{{ scope.row.billCode }}</template>
        </el-table-column>
        <el-table-column label="申领人员" align="center">
          <template slot-scope="scope">{{ scope.row.applicationUser }}</template>
        </el-table-column>
        <!--        <el-table-column label="单据日期" align="center">-->
        <!--          <template slot-scope="scope">{{ scope.row.billDate | formatDateTime }}</template>-->
        <!--        </el-table-column>-->
        <el-table-column label="出库人员" align="center">
          <template slot-scope="scope">{{ scope.row.billCreator }}</template>
        </el-table-column>
        <el-table-column label="创建时间" align="center">
          <template slot-scope="scope">{{ scope.row.createTime | formatDateTime }}</template>
        </el-table-column>
        <el-table-column label="备注" align="center">
          <template slot-scope="scope">{{ scope.row.remark }}</template>
        </el-table-column>
        <!--        <el-table-column label="出库科室名称" align="center">-->
        <!--          <template slot-scope="scope">{{ scope.row.branchName }}</template>-->
        <!--        </el-table-column>-->
        <!--        <el-table-column label="申请日" align="center">-->
        <!--          <template slot-scope="scope">{{ scope.row.applicationDate | formatDateTime }}</template>-->
        <!--        </el-table-column>-->

        <el-table-column label="操作" width="180" align="center">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              @click="handleViewOrder(scope.$index, scope.row)">查看
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDeleteOutBill(scope.$index, scope.row)">删除
            </el-button>

          </template>
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
import {deleteOutBill, fetchList} from '@/api/outBill';
import {deleteOutBillDetail} from "@/api/outDetail";
import {deleteOutBillDetailItem} from "@/api/outItem";
import {formatDate} from '@/utils/date';
import {getCookie} from '@/utils/support';

const defaultListQuery = {
  pageNum: 1,
  pageSize: 50,
  keyword: null,
  reagentId: null,
  reagentName: null,
  supplierName: null,
  factory: null,
  reagentStatus: null,
  reagentTemp: null,
  billType: null,
  username: getCookie("username"),
};
const defaultCentreOut = {
  id: null,
  code: null,
  reagentId: null,
  reagentName: null,
  reagentType: null,
  factory: null,
  supplierName: null,
  reagentStatus: null,
  reagentUnit: null,
  quantity: null,
  reagentTemp: null,
  overdue: null,
  lowStock: null,
  billType: 1
};
export default {
  name: 'CentreOutList',
  data() {
    return {
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      loading: false,
      listLoading: false,
      dialogVisible: false,
      CentreOut: Object.assign({}, defaultCentreOut),
      allCentreOutList: [],
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
    }
  },
  created() {
    this.getList();
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
    handleViewOrder(index, row) {
      this.$router.push({
        path: '/dms/outDetail',
        query: {
          billCode: row.billCode,
          billType: 1,
        },
      });
    },
    handleResetSearch() {
      this.listQuery = Object.assign({}, defaultListQuery);
    },
    handleSearchList() {
      this.listQuery.pageNum = 1;
      this.getList();
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
    handleDeleteOutBill(index, row) {
      let ids = [];
      let billCodes = [];
      ids.push(row.id);
      billCodes.push(row.billCode);
      this.deleteOutBill(ids, billCodes);
    },
    deleteOutBill(ids, billCodes) {
      this.$confirm('是否要进行该删除操作?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let params_id = new URLSearchParams();
        params_id.append("ids", ids);
        let params_code = new URLSearchParams();
        params_code.append("billCodes", billCodes);

        deleteOutBill(params_id).then(response => {
          this.$message({
            message: '删除成功！',
            type: 'success',
            duration: 1000
          });
          this.getList();
        });
        deleteOutBillDetail(params_code);
        deleteOutBillDetailItem(params_code);
      })
    },
    getList() {
      this.listLoading = true;
      this.listQuery.billType = this.CentreOut.billType;
      fetchList(this.listQuery).then(response => {
        this.listLoading = false;
        this.list = response.data.list;
        this.total = response.data.total;
      });
    },

  }
}
</script>
<style></style>


