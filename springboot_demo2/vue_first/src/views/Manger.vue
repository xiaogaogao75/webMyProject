<template>
  <div class="home" style="height: 100%;">
    <el-container style="min-height: 100vh;" >
      <el-aside :width=" sideWidth+'px' " style="background-color: rgb(238,241,246);box-shadow:2px 0 6px rgb(0 21 41/35%)">
        <Aside :isCollapse="isCollapse" :logoTextShow="logoTextShow" />
      </el-aside>
    <el-container>
      <el-header style="border-bottom: 1px solid #ccc;" >
      <Header :collapseBtnClass="collapseBtnClass" :collapse="collapse" />

    </el-header >
    <el-main class="headerBg">
      <!-- 当前页面子路由在在router-view展示-->
      <router-view/>
    </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>

// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import Aside from "@/components/Aside";
import Header from "@/components/Header";
export default {
  name: 'HomeView',
  data(){
    return {
      collapseBtnClass:'el-icon-s-fold',
      Collapse:false,
      sideWidth:200,
      logoTextShow:true,
      isCollapse:false
    }
  },
  components:{
    Header,
    Aside
  },
  methods:{
    collapse(){
      //点击出发侧边导航栏收缩效果
      this.isCollapse=!this.isCollapse
      if (this.isCollapse){
        this.sideWidth=64
        this.collapseBtnClass='el-icon-s-unfold'
        this.logoTextShow=false
      }else{
        this.sideWidth=200
        this.collapseBtnClass='el-icon-s-fold'
        this.logoTextShow=true
      }
    },


  }
}

</script>
