<template>
  <div style="width: 500px; margin: 10px 0;" >
    <h3 style="text-align: center">修改用户信息</h3>
    <el-form  label-width="80px">
      <el-form-item label="昵称"><el-input v-model="form.nickname" autocomplete="off" size="medium" style="width: 350px" ></el-input></el-form-item>
      <el-form-item label="密码"><el-input v-model="form.password" autocomplete="off" size="medium" style="width: 350px" ></el-input></el-form-item>
      <el-form-item label="邮箱"><el-input v-model="form.email" autocomplete="off" size="medium" style="width: 350px" ></el-input></el-form-item>
      <el-form-item label="电话"><el-input v-model="form.phone" autocomplete="off" size="medium" style="width: 350px" ></el-input></el-form-item>
      <el-form-item label="地址"><el-input v-model="form.address" autocomplete="off" size="medium" style="width: 350px" ></el-input></el-form-item>
    </el-form>
    <div>
      <el-button size="medium" type="primary" @click="save" style="margin-left: 200px" >确 定</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserInfo",

  data(){
    return{
      form:{},
      user:localStorage.getItem("user")?JSON.parse(localStorage.getItem("user")): {}
    }
  },
  created() {
     this.requset.get("user")
  },
  methods:{
    save(){
      this.request.post("/user",this.form).then(res =>{
        if (res){
          this.$message.success("保存成功")
        }else {
          this.$message.error("保存失败")
        }
      })
    },
  }
}
</script>

<style scoped>

</style>