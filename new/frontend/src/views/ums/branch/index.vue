<template> 
  <div class="app-container">
    <el-card class="filter-container" shadow="never">

      <div>
        <i class="el-icon-tickets"></i>
        <span>科室列表</span>
      </div>
      <el-button size="small" style="float:left;margin-top: 8px"
                 type="primary" icon="el-icon-circle-plus"
                 @click="handleAdd()">添加科室
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
            <el-input v-model="listQuery.keyword" class="input-width" placeholder="科室号/科室名" clearable
                      @keyup.enter.native="handleSearchList"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </el-card>

    <div class="table-container">
      <el-table ref="branchTable"
                :data="list"
                :row-class-name="rowClassName"
                style="width: 100%;"
                v-loading="listLoading" border>
        <el-table-column prop="newId" align="center" label="序号" width="60"></el-table-column>

<!--        <el-table-column label="科室编号" align="center">-->
<!--          <template slot-scope="scope">{{ scope.row.branchCode }}</template>-->
<!--        </el-table-column>-->
        <el-table-column label="科室名称" align="center">
          <template slot-scope="scope">{{ scope.row.branchName }}</template>
        </el-table-column>
        <el-table-column label="电话" align="center">
          <template slot-scope="scope">{{ scope.row.tel }}</template>
        </el-table-column>
        <el-table-column label="负责人" align="center">
          <template slot-scope="scope">{{ scope.row.head }}</template>
        </el-table-column>
        <el-table-column label="添加时间" width="160" align="center">
          <template slot-scope="scope">{{ scope.row.createTime | formatDateTime }}</template>
        </el-table-column>

        <el-table-column label="操作" width="180" align="center">
          <template slot-scope="scope">

            <el-button size="mini"
                       type="primary"
                       icon="el-icon-edit"
                       @click="handleUpdate(scope.$index, scope.row)">编辑
            </el-button>
            <el-button size="mini"
                       type="danger"
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
        layout="total, sizes,prev, pager, next,jumper"
        :current-page.sync="listQuery.pageNum"
        :page-size="listQuery.pageSize"
        :page-sizes="[50,100,200]"
        :total="total">
      </el-pagination>
    </div>
    <!-- 根据数据库修改 -->
    <el-dialog
      :title="isEdit?'编辑科室':'添加科室'"
      :visible.sync="dialogVisible"
      width="40%">
      <el-form :model="branchForm"
               :rules="branchRules"
               ref="branchForm"
               label-width="150px" size="small">

<!--        <el-form-item label="科室编号：" prop="branchCode" v-show="isEdit">-->
<!--          <el-input-->
<!--            v-bind:disabled="isEdit"-->
<!--            v-model="branchForm.branchCode"-->
<!--            style="width: 250px"></el-input>-->
<!--        </el-form-item>-->
        <el-form-item label="科室名称：" prop="branchName">
          <el-input
            v-bind:disabled="isEdit"
            v-model="branchForm.branchName"
            style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="电话：">
          <el-input v-model="branchForm.tel" style="width: 250px"></el-input>
        </el-form-item>
        <el-form-item label="负责人：">
          <el-input v-model="branchForm.head" style="width: 250px"></el-input>
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

import {createBranch, deleteBranch, fetchAllBranchList, fetchList, updateBranch} from '@/api/branch';
import {formatDate} from '@/utils/date';
import {isvalidUsername} from '@/utils/validate';

const defaultListQuery = {
  pageNum: 1,
  pageSize: 50,
  keyword: null
};
const defaultBranch = {
  id: null,
  branchCode: null,
  branchName: null,
  tel: null,
  head: null,
  status: 1
};
export default {
  name: 'branchList',
  data() {
    const validateUsername = (rule, value, callback) => {
      if (!isvalidUsername(value)) {
        callback(new Error('该选项不能为空'))
      } else {
        callback()
      }
    };
    return {
      branchForm: {
        branchCode: '',
        branchName: '',
        tel: '',
        head: '',
      },
      branchRules: {
        branchName: [
          {required: true, message: '请输入科室名称', trigger: 'blur'},
          {validator: validateUsername, trigger: 'blur'}
        ]
      },
      listQuery: Object.assign({}, defaultListQuery),
      list: null,
      total: null,
      loading: false,
      listLoading: false,
      dialogVisible: false,

      isEdit: false,
      allocDialogVisible: false,
      allocRoleIds: [],
      allRoleList: [],
      allocBranchId: null
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
      this.branchForm = Object.assign({}, defaultBranch);
    },

    handleDelete(index, row) {
      this.$confirm('是否要删除该用户?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteBranch(row.id).then(response => {
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
      this.branchForm = Object.assign({}, row);
    },
    handleDialogConfirm() {
      this.$refs.branchForm.validate(valid => {
        if (valid) {
          if (this.isEdit) {
            updateBranch(this.branchForm.id, this.branchForm).then(response => {
              this.$message({
                message: '修改成功！',
                type: 'success'
              });
              this.dialogVisible = false;
              this.getList();
            })
          } else {
            createBranch(this.branchForm).then(response => {
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
    getAllRoleList() {
      fetchAllBranchList().then(response => {
        this.allRoleList = response.data;
      });
    },

  }
}
</script>
<style>

</style>


