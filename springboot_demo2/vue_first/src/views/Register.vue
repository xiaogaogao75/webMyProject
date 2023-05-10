<template>
  <div class="wrapper">
    <div style="margin: 200px auto;background-color: #fff;width: 350px;height: 350px;padding: 20px;border-radius: 10px">
      <div style="margin: 20px 0;text-align: center;font-size: 24px"><b>注册</b></div>
        <el-form :model="user" :rules="rules" ref="userFrom">
          <el-form-item prop="username">
            <el-input placeholder="请输入用户名"  size="medium" style="margin: 10px 0" prefix-icon="el-icon-user" v-model="user.username"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input placeholder="请输入密码"  size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
          </el-form-item>
          <el-form-item prop="confirmPassword">
            <el-input placeholder="请确认密码" size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" show-password v-model="user.confirmPassword"></el-input>
          </el-form-item>
          <div style="margin: 10px 0;text-align: right">
            <el-button type="primary" size="small" autocomplete="off" @click="login" >确定</el-button>
            <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/login')">返回登录</el-button>
          </div>
        </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Register",
  data(){
    return {
      user:{},
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 5, max: 10, message: '长度在 6 到 20 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 5, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur' }
        ],
        confirmPassword: [
          { required: true, message: '请确认密码', trigger: 'blur' },
          { min: 5, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur' }
        ]
      },
    }
  },
  methods:{
    login(){
      this.$refs['userFrom'].validate((valid) => {
        if (valid) {
          if (this.user.password !== this.user.confirmPassword){
            this.$message.error("两次输入密码不一致")
          }else {
          this.request.post("/user/register",this.user).then(res =>{
            if (!res){
              this.$message.error("用户已经存在，请重新输入")
            }else {
              this.$message.success("成功注册")
              this.$router.push("/root")
            }
          })}
        } else {
          return false;
        }
      })
    }
  }
}
</script>

<style scoped>
  .wrapper{
    height: 100vh;
    background-image: linear-gradient(to bottom right,#ead6ee,#a0f1ea);
    overflow: hidden;
  }

</style>