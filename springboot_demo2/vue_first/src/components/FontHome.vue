<template>
  <div style="display: flex;">
    <div style="width: 600px;height: 100px;font-size: 40px;margin-left: 30px;margin-top: 40px" >
      <h1 >Question bank is free for YOU</h1>
      <h6 >This website provides you with the brush service, you can accumulate knowledge here</h6>
    </div>
    <div style="margin-left: 100px"><img src="../assets/main.png"></div>
    <el-card style="position: absolute;left: 700px ;bottom: 40px ;font-size: 30px;
    line-height: 20px;background-color: #ffe56f ;box-shadow: 5px 5px 2px #ffe56f;cursor: pointer">
      <b @click="$router.push('/fontexercise')">Begin</b>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "fonthome"
}
</script>

<style scoped>

</style>