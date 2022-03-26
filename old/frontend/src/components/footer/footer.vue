<template>
  <div class='footer'>

    <span class="copyright">版权所有 JNL</span>
    <el-drawer
      title="联系我"
      :visible.sync="drawer"
      :direction="direction"
      :before-close="handleClose">
      <p class='info'>
        <i class="el-icon-phone"></i>电话：18822299999<br/>
        <i class="el-icon-message"></i>邮箱：18822299999@163.com<br/>
      </p>
    </el-drawer>
  </div>
</template>
<style>
.el-divider{
  background-color: rgb(84, 92, 100);
}
</style>
<style scoped>
.footer{
  height: 100px;
  text-align: center;
  font-size: 16px;
  padding: 0px 100px;
  position: relative;
}

.copyright{
  font-size: 16px;
}
.info{
  font-size: 14px;
  color: #72767b;
  line-height: 25px;
}


</style>
<script>
export default {
  name: 'Footer',
  data () {
    return {
      drawer: false,
      direction: 'btt'
    }
  },
  methods: {
    handleClose (done) {
      done()
    }
  }
}
</script>

