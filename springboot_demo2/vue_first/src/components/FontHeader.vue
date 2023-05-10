<template>

  <div style="display: flex; line-height: 65px;background-color: white;width: 100%;box-shadow: 0px 6px 6px 0px rgba(0,0,0,0.1)" >
    <!--logo-->
    <div style="margin-left: 400px ;line-height: 18px;" @click="$router.push('/')" >
      <img src="../assets/logo.png" alt="" style="width: 50px; height: 50px;margin: 10px auto;"></div>
    <!--导航栏-->
    <div style="margin-left: 40px">
      <el-menu  text-color="#000000" active-text-color="green" class="el-menu-demo" mode="horizontal">
        <el-menu-item index="1" @click="$router.push('/')" >首页</el-menu-item>
        <el-submenu index="2">
          <template slot="title"><span @click="$router.push('/fontexercise')">题库</span>  </template>
          <el-menu-item index="2-1" @click="$router.push('/exercise')">专项练习</el-menu-item>
          <el-menu-item index="2-2" @click="$router.push('/companyquestion')" >公司真题</el-menu-item>
        </el-submenu>
        <el-menu-item index="3" @click="$router.push('/onlinejudgment')" >在线编程</el-menu-item>
      </el-menu>
    </div>
    <div style="margin-left: 200px">
      <el-dropdown trigger="click" style="width: 70px ; cursor: pointer">
        <span class="el-dropdown-link" style="font-size: 17px">我的<i class="el-icon-arrow-down el-icon--right"></i></span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item ><span style="font-size: 16px" @click="$router.push('/login')">&nbsp;&nbsp;登录 &nbsp;&nbsp;</span></el-dropdown-item>
          <el-dropdown-item ><span style="font-size: 16px" @click="$router.push('/register')">&nbsp;&nbsp;注册&nbsp;&nbsp;</span></el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
export default {
  name: "FontHeader"
}
</script>

<style scoped>

</style>