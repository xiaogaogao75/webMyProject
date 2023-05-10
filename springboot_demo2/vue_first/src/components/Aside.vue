<template>
  <el-menu :default-openeds="['1', '6']"
           :collapse-transition="false"
           :collapse="isCollapse"
           style=" overflow-x: hidden ; min-height: 100%"
           background-color="rgb(48,65,86)"
           text-color="#fff"
           active-text-color="ffd04b"
           router>
    <div style="height: 60px;line-height: 60px ;text-align: center">
      <img src="../assets/logo.png" style="width: 20px;position: relative;margin-right: 5px">
      <b style="color: white" v-show="logoTextShow">在线考试管理系统</b>
    </div>
    <el-menu-item index="/root">
      <template slot="title"><i class="el-icon-house"></i> <span slot="title">主页</span></template>
    </el-menu-item>
    <el-submenu index="2">
      <template slot="title"><i class="el-icon-menu"></i><span slot="title"> 常用设置</span></template>
      <el-menu-item-group>
        <el-menu-item index="/root/user" class="el-icon-user-solid"> 用户管理</el-menu-item>
        <el-menu-item index="/root/role" class="el-icon-menu"> 权限管理</el-menu-item>
        <el-menu-item index="/root/menu" class="el-icon-s-order"> 菜单管理</el-menu-item>
        <el-menu-item index="2-2"class="el-icon-pie-chart"> 统计数据</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
    <el-submenu index="3">
      <template slot="title"><i class="el-icon-s-order"></i><span slot="title">试题管理</span></template>
      <el-menu-item-group>
        <el-menu-item index="2-1" class="el-icon-postcard"> 题目管理</el-menu-item>
        <el-menu-item index="2-2" class="el-icon-monitor"> 考试安排</el-menu-item>
        <el-menu-item index="2-3" class="el-icon-document-copy"> 考试作答</el-menu-item>
        <el-menu-item index="2-4" class="el-icon-pie-chart"> 成绩统计</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
<!--    <el-submenu index="4">-->
<!--      <template slot="title"><i class="el-icon-trophy-1"></i><span slot="title">奖杯管理</span></template>-->
<!--      <el-menu-item-group>-->
<!--        <el-menu-item index="2-1">选项1</el-menu-item>-->
<!--        <el-menu-item index="2-2">选项2</el-menu-item>-->
<!--        <el-menu-item index="2-3">选项3</el-menu-item>-->
<!--        <el-menu-item index="2-4">选项4</el-menu-item>-->
<!--      </el-menu-item-group>-->
<!--    </el-submenu>-->
<!--    <el-submenu index="5">-->
<!--      <template slot="title"><i class="el-icon-chat-dot-square"></i><span slot="title">讨论管理</span></template>-->
<!--      <el-menu-item-group>-->
<!--        <el-menu-item index="2-1">选项1</el-menu-item>-->
<!--        <el-menu-item index="2-2">选项2</el-menu-item>-->
<!--        <el-menu-item index="2-3">选项3</el-menu-item>-->
<!--        <el-menu-item index="2-4">选项4</el-menu-item>-->
<!--      </el-menu-item-group>-->
<!--    </el-submenu>-->
  </el-menu>
</template>

<script>
export default {
  name: "Aside",
  props: {
    isCollapse: Boolean,
    logoTextShow:Boolean
  },
}
</script>

<style scoped>

</style>