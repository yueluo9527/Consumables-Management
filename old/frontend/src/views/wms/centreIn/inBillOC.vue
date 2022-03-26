<template> 
  <div class="app-container">
    <el-card class="filter-container" shadow="never">

      <div>
        <i class="el-icon-tickets"></i>
        <span>入库列表</span>
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
            <el-input v-model="listQuery.keyword" class="input-width" placeholder="入库编号/供货商"
                      @keyup.enter.native="handleSearchList"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <div class="table-container">
      <el-table ref="CentreInTable"
                :data="list"
                :row-class-name="rowClassName"
                max-height="600"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column prop="newId" align="center" label="序号" width="60"></el-table-column>

        <el-table-column label="入库单号" min-width="130%" align="center">
          <template slot-scope="scope">{{ scope.row.billCode }}</template>
        </el-table-column>
        <el-table-column label="供货商" align="center">
          <template slot-scope="scope">{{ scope.row.supplierShortName }}</template>
        </el-table-column>
        <el-table-column label="制单人员" align="center">
          <template slot-scope="scope">{{ scope.row.billCreator }}</template>
        </el-table-column>
        <el-table-column label="单据状态" align="center">
          <template slot-scope="scope">
            {{ scope.row.billStatus ? statusData[(scope.row.billStatus)].label : '复核完成' }}
          </template>
        </el-table-column>
        <el-table-column label="创建时间" align="center">
          <template slot-scope="scope">{{ scope.row.createTime | formatDateTime }}</template>
        </el-table-column>
        <el-table-column label="更新时间" align="center">
          <template slot-scope="scope">{{ scope.row.updateTime | formatDateTime }}</template>
        </el-table-column>
        <el-table-column label="备注" align="center">
          <template slot-scope="scope">{{ scope.row.remark }}</template>
        </el-table-column>

        <el-table-column label="操作" width="250" align="center">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              @click="handleViewLook(scope.$index, scope.row)"
              v-show="scope.row.billStatus==1">查看
            </el-button>
            <el-button
              size="mini"
              type="primary"
              @click="handlePrint(scope.$index, scope.row)"
              v-show="scope.row.billStatus==1 && scope.row.createType==1">打印
            </el-button>
            <!--  <el-button
               size="mini"
               type="primary"
               @click="handlePrint(scope.$index, scope.row)"
               v-show="scope.row.billStatus==1 && scope.row.createType==3">补打
             </el-button>-->
            <el-button
              size="mini"
              type="primary"
              @click="handleViewLook(scope.$index, scope.row)"
              v-show="scope.row.billStatus==0">查看
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDeleteInBill(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>

      </el-table>
    </div>
    <div style="display:none;">
      <el-table ref="inBillItemTable"
                :data="codePicList"
                max-height="550"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column label="二维码" width="350%" align="center">
          <template slot-scope="scope">
            <div>
              <div class="qrcode-pic" ref="codeItem">
                <vue-qr :text="scope.row.qrCode" :size="110" :margin="0"></vue-qr>
              </div>
              <div v-html="scope.row.qrCodeValue" class="right" align="left"></div>
            </div>
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
import {deleteInBill, fetchList, searchCodeList} from '@/api/inBill';
import {deleteInBillDetail} from "@/api/inBillDetail";
import {deleteInBillDetailItem} from "@/api/inBillItem";
import {formatDate} from '@/utils/date';
import {getCookie} from '@/utils/support';
import VueQr from "vue-qr";

const defaultListQuery = {
  pageNum: 1,
  pageSize: 50,
  keyword: null,
  billType: null,
  username: getCookie("username"),
  billCode: null,
  createType: null
};
const defaultCentreIn = {
  id: null,
  billType: 1,
};
export default {
  name: 'CentreInList',
  data() {
    return {
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      loading: false,
      listLoading: false,
      codePicList: null,
      dialogVisible: false,
      centreIn: Object.assign({}, defaultCentreIn),

      //入库单状态
      statusData: [
        {
          label: '复核完成',
          value: 0
        },
        {
          label: '复核完成并入库',
          value: 1
        }
      ],
    }
  },
  components: {
    VueQr
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
    handleViewLook(index, row) {
      this.$router.push({
        path: '/wms/inBillDetail',
        query: {
          billCode: row.billCode,
          billStatus: row.billStatus,
          supplierName: row.supplierShortName,
          billType: this.centreIn.billType
        }
      })
    },
    handlePrint(index, row) {
      this.listQuery.billCode = row.billCode;
      this.listQuery.createType = row.createType;
      searchCodeList(this.listQuery).then(response => {
        this.listLoading = false;
        this.codePicList = response.data;

        if (this.codePicList.length > 0) {
          setTimeout(() => {
            const that = this;
            this.$nextTick(() => {
              let arrDom = document.querySelectorAll(".qrcode-pic");
              let iframe = document.createElement('IFRAME');
              iframe.setAttribute('style', 'position: absolute: width:0px; height: 0px; left: -500px; top:-500px;');
              document.body.appendChild(iframe);
              let doc = iframe.contentWindow.document;

              for (let i = 0; i < that.codePicList.length; i++) {
                doc.write(`
                <div class="long">
                         <div class="qrcode">${arrDom[i].innerHTML}</div>
                         <div class="qrCodeValue">${that.codePicList[i].qrCodeValue}</div>
                </div>
                <div style="page-break-after: always"><br /></div>
            `);
              }
              doc.write(`
            <style>
              .long {
                width: 250px;
                height: 100px;
                padding: 2rem;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                margin: auto;
              }
              .qrcode{
                width: 110px;
                height: 110px;
                float: left;
              }
              .qrCodeValue{
                width: 120px;
                height: 100px;
                float: right;
                font-size:8px;
                word-break:break-all;
              }
            </style>
          `);
              iframe.contentWindow.print();
              iframe.parentNode.removeChild(iframe);

              // ! 打印二维码备选方案
              // doc.write(`

              //   <script>
              //     function _print() {
              //       window.print();
              //     }
              //     // window.print();
              //   <\/script>
              // `);

              //   const wnd = window.document.open('""', 'print', '""');
              //   let _html = `
              //     <html>
              //       <head>
              //         <style>
              //           .long {
              //             width: 250px;
              //             height: 100px;
              //             padding: 2rem;
              //             top: 0;
              //             left: 0;
              //             right: 0;
              //             bottom: 0;
              //             margin: auto;
              //           }
              //           .qrcode{
              //             width: 110px;
              //             height: 110px;
              //             float: left;
              //           }
              //           .qrCodeValue{
              //             width: 120px;
              //             height: 100px;
              //             float: right;
              //             font-size:8px;
              //             word-break:break-all;
              //           }
              //         </style>
              //       </head>
              //       <body>
              //   `;

              //   for (let i = 0; i < that.codePicList.length; i++) {
              //       _html += `
              //         <div class="long">
              //           <div class="qrcode">${arrDom[i].innerHTML}</div>
              //           <div class="qrCodeValue">${that.codePicList[i].qrCodeValue}</div>
              //         </div>
              //         <div style="page-break-after: always"><br /></div>
              //       `;
              //     }

              //   _html += `</body></html>`;

              //   wnd.document.write(_html);
              //   wnd.print();
            })
          }, 100);
        } else {
          this.$message({
            message: '此单中未有需要打印二维码！',
            type: 'warning',
            duration: 1500
          });
        }
      });
    },
    handleViewEdit(index, row) {
      if (row.createType == 1) {
        this.$router.push({
          path: '/wms/createInBillOC',
          query: {billCode: row.billCode}
        })
      } else if (row.createType == 3) {
        this.$router.push({
          path: '/wms/scanInBillOC',
          query: {billCode: row.billCode, preBillCode: row.preInBillCode}
        })
      }
    },
    handleResetSearch() {
      this.listQuery = Object.assign({}, defaultListQuery);
      this.listQuery.pageNum = 1;
      this.getList();
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
    handleDeleteInBill(index, row) {
      let ids = [];
      let billCodes = [];
      ids.push(row.id);
      billCodes.push(row.billCode);
      this.deleteInBill(ids, billCodes);
    },
    deleteInBill(ids, billCodes) {
      this.$confirm('是否要进行该删除操作?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let params_id = new URLSearchParams();
        params_id.append("ids", ids);
        let params_code = new URLSearchParams();
        params_code.append("billCodes", billCodes);

        deleteInBill(params_id).then(response => {
          this.$message({
            message: '删除成功！',
            type: 'success',
            duration: 1000
          });
          this.getList();
        });
        deleteInBillDetail(params_code);
        deleteInBillDetailItem(params_code);
      })
    },
    getList() {
      this.listLoading = true;
      this.listQuery.billType = this.centreIn.billType;
      fetchList(this.listQuery).then(response => {
        this.listLoading = false;
        this.list = response.data.list;
        this.total = response.data.total;
      });
    },
  }
}
</script>
<style type="text/css">
.qrcode-pic {
  float: left;
  margin-left: 20px;
  margin-top: 20px;
}

.right {
  position: center;
  float: left;
  font-size: 12px;
  width: 45%;
  margin-left: 20px;
}
</style>


