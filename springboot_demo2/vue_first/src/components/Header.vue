<template>
    <div style="font-size: 12px; line-height: 60px;display: flex">
    <div style="flex: 1;font-size: 18px " >
      <span :class="collapseBtnClass" style="cursor: pointer;" @click="collapse" ></span>
    </div>
    <el-dropdown style="width: 70px ; cursor: pointer" >
      <span>{{user.nickname}}</span><i class="el-icon-arrow-down" style="margin-right: 5px"></i>
      <el-dropdown-menu slot="dropdown" >
        <el-dropdown-item style="font-size: 14px;padding: 5px 0">
          <span @click="$router.push('/root/userinfo')">&nbsp;&nbsp;个人信息&nbsp;&nbsp;</span></el-dropdown-item>
        <el-dropdown-item style="font-size: 14px;padding: 5px 0;text-align: center" >
          <span @click="logout" style="text-decoration: none ;">退出</span>
        </el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
    </div>

</template>

<script>
export default {
  name: "Header",
  props:{
    collapseBtnClass:String,
    collapse:Boolean
  },
  created() {
    this.open1()
  },
  data(){
    return{
      user:localStorage.getItem("user")?JSON.parse(localStorage.getItem("user")): {}
    }
  },
  methods:{
    open1() {
      const h = this.$createElement;
      this.$notify({
        title: '通知',
        message: h('i', { style: 'color: teal'}, '成功登录!欢迎您的到来!'),
        duration: 3000
      });
    },
    logout(){
      this.$router.push("/login")
      localStorage.removeItem("user")
      this.$message.success("退出成功")
    },
    // userinfo(){
    //   this.$router.push("/root/userinfo")
    // }

  }
}
</script>

<style scoped>

</style>