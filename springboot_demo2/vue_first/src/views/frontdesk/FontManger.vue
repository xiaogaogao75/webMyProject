<template >
  <div style="height: 100vh;background-color: white;">
<!--    头部-->
    <el-container>
      <font-header/>
    </el-container>
<!--body-->
    <div style="width: 90%;margin:  auto;display: flex;background-color: white;" >
      <el-container>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script>
import FontHeader from "@/components/FontHeader";
import Fonthome from "@/components/FontHome";
export default {
  name: "FontManger",
  components: {Fonthome, FontHeader}
}
</script>

<style scoped>

</style>