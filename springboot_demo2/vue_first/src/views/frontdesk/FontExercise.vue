<template>
  <div style="width: 800px;margin: 150px 35vh;">
    <el-row :gutter="10">
      <el-col :span="12">
        <el-card class="box-card" style="width: 300px;text-align: center" shadow="hover">
          <div slot="header" ><span style="font-size: 20px"><b>专项练习</b></span></div>
          <div  style="margin: 40px auto">
            <el-button type="success" style="font-size: 25px" @click="$router.push('/exercise')">进入</el-button>
          </div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card class="box-card" style="width: 300px;text-align: center" shadow="hover">
          <div slot="header" ><span style="font-size: 20px"><b>公司真题</b></span></div>
          <div  style="margin: 40px auto">
            <el-button type="success" style="font-size: 25px" @click="$router.push('/companyquestion')">进入</el-button>
          </div>
        </el-card>
      </el-col>
    </el-row>


  </div>
</template>

<script>
export default {
  name: "FontExercise"
}
</script>

<style scoped>

</style>