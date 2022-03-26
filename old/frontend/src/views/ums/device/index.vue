<template> 
  <div class="app-container">
    <el-card class="filter-container" shadow="never">

      <div>
        <i class="el-icon-tickets"></i>
        <span>设备列表</span>
      </div>
      <el-button size="small" style="float:left;margin-top: 8px"
                 type="primary" icon="el-icon-circle-plus"
                 @click="handleAdd()">添加设备
      </el-button>
      <el-button
        size="small"
        style="margin-top: 8px;
               float:left;
               margin-left:20px"
        type="primary"
        icon="el-icon-download"
        @click="printCode">打印二维码
      </el-button>

      <el-button size="small" style="float:right;margin-right: 15px;margin-top: 8px"
                 type="primary" :loading="loading"
                 @click.native.prevent="handleSearchList">
        查询搜索
      </el-button>
      <el-button
        style="float:right;margin-right: 10px;margin-top: 8px"
        @click="handleResetSearch()"
        size="small">
        重置
      </el-button>
      <div style="float:right;margin-top: 8px">
        <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
          <el-form-item>
            <el-input v-model="listQuery.keyword" class="input-width" placeholder="设备编号/设备名称" clearable
                      @keyup.enter.native="handleSearchList"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>

    <div class="table-container">
      <el-table ref="deviceTable"
                :data="list"
                :row-class-name="rowClassName"
                style="width: 100%;"
                @selection-change="handleSelectionChange"
                v-loading="listLoading" border>
        <el-table-column type="selection" width="40" align="center"></el-table-column>
        <el-table-column prop="newId" align="center" label="序号" width="60"></el-table-column>
        <el-table-column label="设备编号" align="center">
          <template slot-scope="scope">{{ scope.row.deviceCode }}</template>
        </el-table-column>
        <el-table-column label="设备名称" align="center">
          <template slot-scope="scope">{{ scope.row.deviceName }}</template>
        </el-table-column>
        <el-table-column label="设备二维码" width="320%" align="center">
          <template slot-scope="scope">
            <div>
              <div class="qrcode-pic" :class="'qrcode' + scope.row.newId" ref="codeItem">
                <vue-qr :text="scope.row.deviceQrCode" :size="110" :margin="0"></vue-qr>
              </div>
              <div v-html="scope.row.deviceCodeValue" class="right" align="left"></div>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="添加时间" width="160" align="center">
          <template slot-scope="scope">{{ scope.row.createTime | formatDateTime }}</template>
        </el-table-column>
        <el-table-column label="更新时间" width="160" align="center">
          <template slot-scope="scope">{{ scope.row.updateTime | formatDateTime }}</template>
        </el-table-column>
        <el-table-column label="是否启用" width="100" align="center">
          <template slot-scope="scope">
            <el-switch
              @change="handleStatusChange(scope.$index, scope.row)"
              :active-value="1"
              :inactive-value="0"
              v-model="scope.row.deviceStatus">
            </el-switch>
          </template>
        </el-table-column>

        <el-table-column label="操作" width="180" align="center">
          <template slot-scope="scope">

            <el-button size="mini"
                       type="primary"
                       icon="el-icon-edit"
                       @click="handleUpdate(scope.$index, scope.row)">编辑
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
    <!-- 根据数据库修改 -->
    <el-dialog
      :title="'编辑设备'"
      :visible.sync="editDialogVisible"
      width="40%">
      <el-form :model="deviceForm"
               :rules="deviceRules"
               ref="deviceForm"
               label-width="150px" size="small">
        <el-form-item label="设备编号：" prop="deviceCode">
          <el-input v-model="deviceForm.deviceCode" onkeyup="value=value.replace(/^(0+)|[^\d]+/g,'')"
                    style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="设备名称：" prop="deviceName">
          <el-input v-model="deviceForm.deviceName" style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="是否启用：">
          <el-radio-group v-model="deviceForm.deviceStatus">
            <el-radio :label="1">是</el-radio>
            <el-radio :label="0">否</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editDialogVisible = false" size="small">取 消</el-button>
        <el-button type="primary" @click="handleDialogConfirm()" size="small">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog
      :title="'添加设备'"
      :visible.sync="dialogVisible"
      width="40%">
      <el-form :model="deviceForm"
               :rules="deviceRules"
               ref="deviceForm"
               label-width="150px" size="small">
        <el-form-item label="设备名称：" prop="deviceName">
          <el-input v-model="deviceForm.deviceName" style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="是否启用：">
          <el-radio-group v-model="deviceForm.deviceStatus">
            <el-radio :label="1">是</el-radio>
            <el-radio :label="0">否</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" size="small">取 消</el-button>
        <el-button type="primary" @click="handleDialogConfirm()" size="small">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>

import {createDevice, deleteDevice, fetchList, updateDevice, updateStatus} from '@/api/device';
import {formatDate} from '@/utils/date';
import {isvalidUsername} from '@/utils/validate';
import VueQr from "vue-qr";
import {getCookie} from "../../../utils/support";

const defaultListQuery = {
  pageNum: 1,
  pageSize: 50,
  keyword: null,
  createBy: getCookie("username")
};
const defaultDevice = {
  id: null,
  deviceCode: null,
  deviceName: null,
  deviceStatus: 1,
  createBy: getCookie("username")
};
export default {
  name: 'deviceList',
  data() {
    const validateUsername = (rule, value, callback) => {
      if (!isvalidUsername(value)) {
        callback(new Error('该选项不能为空'))
      } else {
        callback()
      }
    };
    return {
      deviceForm: {
        deviceCode: '',
        deviceName: '',
        deviceStatus: 1,
        createBy: getCookie("username")
      },
      deviceRules: {
        deviceName: [
          {required: true, message: '请输入设备名称', trigger: 'blur'},
          {validator: validateUsername, trigger: 'blur'}
        ],
        deviceCode: [
          {required: true, message: '请输入设备编号', trigger: 'blur'},
          {validator: validateUsername, trigger: 'blur'}
        ]
      },
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      loading: false,
      listLoading: false,
      dialogVisible: false,
      editDialogVisible: false,
      allocDialogVisible: false,
      multipleSelection: [],
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
    handleAdd() {
      this.dialogVisible = true;
      this.deviceForm = Object.assign({}, defaultDevice);
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    printCode() {
      if (this.multipleSelection.length <= 0) {
        this.$message({
          message: '未选择要打印的设备！',
          type: 'warning',
          duration: 1500
        });
      } else {
        setTimeout(() => {
          const that = this;
          this.$nextTick(() => {
            let iframe = document.createElement('IFRAME');
            iframe.setAttribute('style', 'position: absolute: width:0px; height: 0px; left: -500px; top:-500px;');
            document.body.appendChild(iframe);
            let doc = iframe.contentWindow.document;

            for (let i = 0; i < that.multipleSelection.length; i++) {
              const item = that.multipleSelection[i];
              const domItem = document.querySelector(`.qrcode${item.newId}`);

              doc.write(`
                <div class="long">
                  <div class="qrcode">${domItem.innerHTML}</div>
                  <div class="codeValue">${item.deviceCodeValue}</div>
                </div>
                ${i < that.multipleSelection.length - 1 ? '<div style="page-break-after: always"></div>' : ''}
               `);
            }

            doc.write(`
              <style>
              @media print {
                  @page {
                      margin: 1mm;
                  }
                }
                .long {
                  width: 300px;
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
                .codeValue{
                  width: 170px;
                  height: 100px;
                  float: right;
                  font-size:18px;
                  word-break:break-all;

              </style>
            `);

            iframe.contentWindow.print();
            iframe.parentNode.removeChild(iframe);
          })
        }, 100)
      }
    },
    handleDelete(index, row) {
      this.$confirm('是否要删除该设备?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteDevice(row.id).then(response => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          this.getList();
        });
      });
    },
    handleUpdate(index, row) {
      this.editDialogVisible = true;
      this.deviceForm = Object.assign({}, row);
    },
    handleStatusChange(index, row) {
      this.$confirm('是否要修改该状态?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        updateStatus(row.id, {deviceStatus: row.deviceStatus}).then(response => {
          this.$message({
            type: 'success',
            message: '修改成功!'
          });
          this.getList();
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消修改'
        });
        this.getList();
      });
      //this.getList();
    },
    handleDialogConfirm() {
      this.$refs.deviceForm.validate(valid => {
        if (valid) {
          if (this.editDialogVisible) {
            updateDevice(this.deviceForm.id, this.deviceForm).then(response => {
              this.$message({
                message: '修改成功！',
                type: 'success'
              });
              this.editDialogVisible = false;
              this.getList();
            })
          } else if (this.dialogVisible) {
            createDevice(this.deviceForm).then(response => {
              this.$message({
                message: '添加成功！',
                type: 'success'
              });
              this.dialogVisible = false;
              this.getList();
            })
          }
        } else {
          console.log('参数验证不合法！');
          this.$message({
            message: '操作失败！',
            type: 'warning'
          });
          return false
        }
      })
    },
    getList() {
      this.listLoading = true;
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
  font-size: 18px;
  width: 45%;
  margin-left: 10px;
  margin-top: 18px;
}
</style>


