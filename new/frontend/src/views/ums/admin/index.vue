<template> 
  <div class="app-container">
    <el-card class="filter-container" shadow="never">

      <div>
        <i class="el-icon-tickets"></i>
        <span>用户列表</span>
      </div>
      <el-button size="small" style="float:left;margin-top: 8px"
                 type="primary" icon="el-icon-circle-plus"
                 @click="handleAdd()">添加用户
      </el-button>

      <el-button size="small" style="float:right;margin-right:15px;margin-top: 8px"
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
            <el-input v-model="listQuery.keyword" class="input-width" placeholder="用户名/真实姓名" clearable
                      @keyup.enter.native="handleSearchList"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <div class="table-container">
      <el-table ref="adminTable"
                :data="list"
                :row-class-name="rowClassName"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column prop="newId" align="center" label="序号" width="60"></el-table-column>

        <el-table-column label="用户名" align="center">
          <template slot-scope="scope">{{ scope.row.username }}</template>
        </el-table-column>
        <el-table-column label="真实姓名" align="center">
          <template slot-scope="scope">{{ scope.row.trueName }}</template>
        </el-table-column>
        <el-table-column label="科室" align="center">
          <template slot-scope="scope">{{ scope.row.branch }}</template>
        </el-table-column>
        <el-table-column label="供货商" align="center">
          <template slot-scope="scope">{{ scope.row.supplier }}</template>
        </el-table-column>
        <el-table-column label="组别" align="center">
          <template slot-scope="scope">{{ scope.row.groupName }}</template>
        </el-table-column>
        <el-table-column label="手机号码" align="center">
          <template slot-scope="scope">{{ scope.row.phone }}</template>
        </el-table-column>
        <el-table-column label="邮箱" align="center">
          <template slot-scope="scope">{{ scope.row.email }}</template>
        </el-table-column>
        <el-table-column label="地址" align="center">
          <template slot-scope="scope">{{ scope.row.address }}</template>
        </el-table-column>
        <el-table-column label="备注" align="center">
          <template slot-scope="scope">{{ scope.row.note }}</template>
        </el-table-column>

        <el-table-column label="是否启用" width="100" align="center">
          <template slot-scope="scope">
            <el-switch
              @change="handleStatusChange(scope.$index, scope.row)"
              :active-value="1"
              :inactive-value="0"
              v-model="scope.row.status">
            </el-switch>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="280" align="center">
          <template slot-scope="scope">
            <el-button size="mini"
                       type="primary"
                       v-show="(roleId != 2 && roleId != 6)"
                       @click="handleSelectRole(scope.$index, scope.row)">分配角色
            </el-button>
            <el-button size="mini"
                       type="primary"
                       icon="el-icon-edit"
                       @click="handleUpdate(scope.$index, scope.row)">编辑
            </el-button>
            <el-button size="mini"
                       type="danger"
                       icon="el-icon-delete"
                       @click="handleDelete(scope.$index, scope.row)">删除
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
        layout="total, sizes, prev, pager, next,jumper"
        :current-page.sync="listQuery.pageNum"
        :page-size="listQuery.pageSize"
        :page-sizes="[50,100,200]"
        :total="total">
      </el-pagination>
    </div>
    <el-dialog
      :title="isEdit?'编辑用户':'添加用户'"
      :visible.sync="dialogVisible"
      width="40%">
      <el-form :model="adminForm"
               :rules="adminRules"
               ref="adminForm"
               label-width="150px" size="small">
        <el-form-item v-show="!isEdit" label="用户名：" prop="username">
          <el-input v-model="adminForm.username" style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="真实姓名：" prop="trueName">
          <el-input v-model="adminForm.trueName" style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="科室名称" v-show="(roleId != 2 && roleId != 6)" prop="branch">
          <el-select v-model="adminForm.branch" placeholder="请选择" size="small" style="width: 250px"
                     @change="handleChange1">
            <el-option
              v-for="item in allBranchList"
              :key="item.id"
              :label="item.branchName"
              :value="item.branchName">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="供货商" prop="supplier">
          <el-select v-model="adminForm.supplier" placeholder="请选择" size="small" style="width: 250px"
                     @change="handleChange2">
            <el-option
              v-for="item in allSupplierList"
              :key="item.id"
              :label="item.supplierShortName"
              :value="item.supplierShortName">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="组别：" v-show="!isEdit">
          <el-input v-model="adminForm.groupName" style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="手机号：">
          <el-input v-model="adminForm.phone" style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="地址：">
          <el-input v-model="adminForm.address" style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="邮箱：">
          <el-input v-model="adminForm.email" style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="密码：" prop="password">
          <el-input v-model="adminForm.password" type="password" style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="备注：">
          <el-input v-model="adminForm.note"
                    type="textarea"
                    :rows="5"
                    style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="是否启用：">
          <el-radio-group v-model="adminForm.status">
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
    <el-dialog
      title="分配角色"
      :visible.sync="allocDialogVisible"
      width="30%">
      <el-select v-model="allocRoleIds" placeholder="请选择" size="small" style="width: 80%">
        <el-option
          v-for="item in allRoleList"
          :key="item.id"
          :label="item.name"
          :value="item.id">
        </el-option>
      </el-select>
      <span slot="footer" class="dialog-footer">
        <el-button @click="allocDialogVisible = false" size="small">取 消</el-button>
        <el-button type="primary" @click="handleAllocDialogConfirm()" size="small">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import {allocRole, createAdmin, deleteAdmin, fetchList, getRoleByAdmin, updateAdmin, updateStatus} from '@/api/login';
import {getRoleListByAdmin} from '@/api/role';
import {formatDate} from '@/utils/date';
import {getCookie} from '@/utils/support';
import {isvalidUsername} from '@/utils/validate';
import {fetchAllSupplierList} from '@/api/supplier';
import {fetchAllBranchList} from '@/api/branch';
import {getRole} from '@/api/order';

const defaultListQuery = {
  pageNum: 1,
  pageSize: 50,
  keyword: null,
  username: getCookie('username'),
};
const defaultAdminForm = {
  username: '',
  password: '',
  trueName: '',
  nickName: '',
  branch: '',
  supplier: '',
  groupName: '',
  phone: '',
  address: '',
  email: '',
  note: '',
  status: 1,
  createBy: getCookie('username'),
};
export default {
  name: 'adminList',
  data() {
    const validateUsername = (rule, value, callback) => {
      if (!isvalidUsername(value)) {
        callback(new Error('该选项不能为空'))
      } else {
        callback()
      }
    };

    const validatePass = (rule, value, callback) => {
      const pwdReg = /^(?=.*\d)(?=.*[a-zA-Z]).{6,}$/;
      if (!value) {
        return callback(new Error("请输入密码"));
      } else if (pwdReg.test(value)) {
        callback();
      } else {
        callback(new Error("请输入包含数字字母的不低于6位数的密码"));
      }
    };
    const validateNum = (rule, value, callback) => {
      if (!this.adminForm.supplier && !this.adminForm.branch) {
        callback(new Error('请至少填写一项'));
      } else {
        callback();
      }
    };
    return {
      adminRules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {validator: validateUsername, trigger: 'blur'}
        ],
        trueName: [
          {required: true, message: '请输入真实姓名', trigger: 'blur'},
          {validator: validateUsername, trigger: 'blur'}
        ],
        password: [
          {required: true, validator: validatePass, trigger: "blur"},
        ],
        supplier: [
          {required: true, validator: validateNum, trigger: 'blur'},
        ],
        branch: [
          {required: true, validator: validateNum, trigger: 'blur'},
        ],
      },
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      loading: false,
      listLoading: false,
      dialogVisible: false,
      adminForm: Object.assign({}, defaultAdminForm),
      isEdit: false,
      allocDialogVisible: false,
      allocRoleIds: [],
      allRoleList: [],
      allocAdminId: null,
      allSupplierList: [],
      allBranchList: [],
      roleId: 0,
    }
  },
  created() {
    this.getList();
    this.fetchRoleList(getCookie('username'));
    this.fetchSupplierList();
    this.fetchBranchList();
    this.getRole();
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
    getRole() {
      getRole(this.listQuery.username).then(response => {
        this.roleId = response.data;
        console.log("role:", this.roleId)
      })
    },
    back() {
      if (window.history.length <= 1) {
        this.$router.push({path: '/'})
        return false
      } else {
        this.$router.go(-1)
      }
    },
    handleChange1() {
      this.adminForm.supplier = "";
    },
    handleChange2() {
      this.adminForm.branch = "";
    },
    fetchBranchList() {
      fetchAllBranchList().then(response => {
        this.allBranchList = response.data;
      });
    },
    fetchSupplierList() {
      fetchAllSupplierList().then(response => {
        this.allSupplierList = response.data;
      });
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
      this.isEdit = false;
      this.adminForm = Object.assign({}, defaultAdminForm);
    },
    handleStatusChange(index, row) {
      this.$confirm('是否要修改该状态?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        updateStatus(row.id, {status: row.status, username: this.listQuery.username}).then(response => {
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
      this.getList();
    },
    handleDelete(index, row) {
      this.$confirm('是否要删除该用户?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteAdmin(row.id, {username: this.listQuery.username}).then(response => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          this.getList();
        });
      });
    },
    handleUpdate(index, row) {
      this.dialogVisible = true;
      this.isEdit = true;
      this.adminForm = Object.assign({}, row);
    },
    handleDialogConfirm() {
      this.$refs.adminForm.validate(valid => {
        if (valid) {
          if (this.isEdit) {
            updateAdmin(this.adminForm.id, this.adminForm).then(response => {
              this.$message({
                message: '修改成功！',
                type: 'success'
              });
              this.dialogVisible = false;
              this.getList();
            })
          } else {
            createAdmin(this.adminForm).then(response => {
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
    handleAllocDialogConfirm() {
      this.$confirm('是否要确认?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let params = new URLSearchParams();
        params.append("adminId", this.allocAdminId);
        params.append("roleIds", this.allocRoleIds);
        allocRole(params).then(response => {
          this.$message({
            message: '分配成功！',
            type: 'success'
          });
          this.allocDialogVisible = false;
        })
      })
    },
    handleSelectRole(index, row) {
      this.allocAdminId = row.id;
      this.allocDialogVisible = true;
      this.getRoleListByAdmin(row.id);
    },
    getList() {
      this.listLoading = true;
      fetchList(this.listQuery).then(response => {
        this.listLoading = false;
        this.list = response.data.list;
        this.total = response.data.total;
      });
    },
    fetchRoleList(adminName) {
      getRoleListByAdmin(adminName).then(response => {
        this.allRoleList = response.data;
      });
    },
    getRoleListByAdmin(adminId) {
      getRoleByAdmin(adminId).then(response => {
        let allocRoleList = response.data;
        this.allocRoleIds = [];
        if (allocRoleList != null && allocRoleList.length > 0) {
          for (let i = 0; i < allocRoleList.length; i++) {
            this.allocRoleIds.push(allocRoleList[i].name);
          }
        }
      });
    }
  }
}
</script>


