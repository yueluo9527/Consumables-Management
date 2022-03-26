<template> 
  <div class="app-container">
    <el-card class="filter-container" shadow="never">

      <div>
        <i class="el-icon-tickets"></i>
        <span>角色列表</span>
      </div>

      <el-button size="small" style="float:left;margin-top: 8px"
                 type="primary" icon="el-icon-circle-plus"
                 @click="handleAdd()">添加角色
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
            <el-input v-model="listQuery.keyword" class="input-width" placeholder="角色名称" clearable
                      @keyup.enter.native="handleSearchList"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>


    <div class="table-container">
      <el-table ref="roleTable"
                :data="list"
                :row-class-name="rowClassName"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column prop="newId" align="center" label="序号" width="60"></el-table-column>

        <el-table-column label="角色名称" align="center">
          <template slot-scope="scope">{{ scope.row.name }}</template>
        </el-table-column>
        <el-table-column label="描述" align="center">
          <template slot-scope="scope">{{ scope.row.description }}</template>
        </el-table-column>
        <el-table-column label="用户数" width="100" align="center">
          <template slot-scope="scope">{{ scope.row.adminCount }}</template>
        </el-table-column>
        <el-table-column label="添加时间" width="160" align="center">
          <template slot-scope="scope">{{ scope.row.createTime | formatDateTime }}</template>
        </el-table-column>
        <el-table-column label="是否启用" width="140" align="center">
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
            <el-row>
              <el-button size="mini"
                         type="primary"
                         @click="handleSelectMenu(scope.$index, scope.row)">分配菜单
              </el-button>

              <el-button size="mini"
                         type="primary"
                         icon="el-icon-edit"
                         @click="handleUpdate(scope.$index, scope.row)"> 编辑
              </el-button>
<!--              <el-button size="mini"
                         type="danger"
                         icon="el-icon-delete"
                         @click="handleDelete(scope.$index, scope.row)">删除
              </el-button>-->
            </el-row>
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
    <el-dialog
      :title="isEdit?'编辑角色':'添加角色'"
      :visible.sync="dialogVisible"
      width="40%">
      <el-form :model="roleForm"
               :rules="roleRules"
               ref="roleForm"
               label-width="150px" size="small">
        <el-form-item label="角色名称：" prop="name">
          <el-input v-model="roleForm.name" style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="描述：" prop="description">
          <el-input v-model="roleForm.description"
                    type="textarea"
                    :rows="5"
                    style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="是否启用：">
          <el-radio-group v-model="roleForm.status">
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
import {createRole, fetchList, updateRole, updateStatus} from '@/api/role';
import {formatDate} from '@/utils/date';
import {isvalidUsername} from '@/utils/validate';
import {getCookie} from "../../../utils/support";

const defaultListQuery = {
  pageNum: 1,
  pageSize: 50,
  keyword: null,
  username: getCookie("username")
};
const defaultRoleForm = {
  name: '',
  description: '',
  adminCount: 0,
  status: 1
};
export default {
  name: 'roleList',
  data() {
    const validateUsername = (rule, value, callback) => {
      if (!isvalidUsername(value)) {
        callback(new Error('该选项不能为空'))
      } else {
        callback()
      }
    };
    return {
      roleRules: {
        name: [
          {required: true, message: '请输入角色名称', trigger: 'blur'},
          {validator: validateUsername, trigger: 'blur'}
        ],
        description: [
          {required: true, message: '请输入角色描述', trigger: 'blur'},
          {validator: validateUsername, trigger: 'blur'}
        ]
      },
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      loading: false,
      listLoading: false,
      dialogVisible: false,
      roleForm: Object.assign({}, defaultRoleForm),
      isEdit: false
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
      this.roleForm = Object.assign({}, defaultRoleForm);
    },
    handleStatusChange(index, row) {
      this.$confirm('是否要修改该状态?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        updateStatus(row.id, {status: row.status}).then(response => {
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

      });
      this.getList();
    },
    /*handleDelete(index, row) {
      this.$confirm('是否要删除该角色?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let ids = [];
        ids.push(row.id);
        let params = new URLSearchParams();
        params.append("ids", ids);
        deleteRole(params).then(response => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          this.getList();
        });
      });
    },*/
    handleUpdate(index, row) {
      this.dialogVisible = true;
      this.isEdit = true;
      this.roleForm = Object.assign({}, row);
    },
    handleDialogConfirm() {
      this.$refs.roleForm.validate(valid => {
        if (valid) {
          if (this.isEdit) {
            updateRole(this.roleForm.id, this.roleForm).then(response => {
              this.$message({
                message: '修改成功！',
                type: 'success'
              });
              this.dialogVisible = false;
              this.getList();
            })
          } else {
            createRole(this.roleForm).then(response => {
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
    handleSelectMenu(index, row) {
      this.$router.push({path: '/ums/allocMenu', query: {roleId: row.id}})
    },
    handleSelectResource(index, row) {
      this.$router.push({path: '/ums/allocResource', query: {roleId: row.id}})
    },
    getList() {
      this.listLoading = true;
      fetchList(this.listQuery).then(response => {
        this.listLoading = false;
        this.list = response.data.list;
        this.total = response.data.total;
      });
    }
  }
}
</script>
<style></style>


