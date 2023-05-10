<template>
  <div>
    <div style="margin-bottom: 30px">
      <el-breadcrumb separator="/" >
        <el-breadcrumb-item :to="{path:'/root'}">首页</el-breadcrumb-item>
        <el-breadcrumb-item >菜单管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div style="margin: 10px 0">
      <el-input style="width: 200px" suffix-icon="el-icon-search" placeholder="请输入名称" v-model="name"></el-input>
      <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
      <el-button  type="warning" @click="reset">重置</el-button>
    </div>
    <div style="margin: 10px 0">
      <el-button type="primary" @click="handAdd">新增<i class="el-icon-circle-plus-outline"></i></el-button>
      <el-popconfirm
          style="margin: 10px"
          confirm-button-text='确定'
          cancel-button-text='我再想想'
          icon="el-icon-info"
          icon-color="red"
          title="您确定删除吗？"
          @confirm="delBatch">
        <el-button type="danger" slot="reference" >批量删除<i class="el-icon-remove-outline"></i></el-button>
      </el-popconfirm>
    </div>
    <el-table :data="tableData" border stripe :header-cell-class-name="headerBg" row-key="id" default-expand-all
              @selection-change="handleSelectionChange">
      <el-table-column type="selection" ></el-table-column>
      <el-table-column prop="id" label="ID" width="80px" ></el-table-column>
      <el-table-column prop="name" label="名称" ></el-table-column>
      <el-table-column prop="path" label="路径" ></el-table-column>
<!--      <el-table-column prop="icon" label="图标" ></el-table-column>-->
      <el-table-column prop="description" label="描述" ></el-table-column>
      <el-table-column  label="操作" width="280px">
        <template v-slot="scope">
          <el-button type="info" @click="handAdd(scope.row.id)" v-if="!scope.row.pid && !scope.row.path">新增子菜单<i class="el-icon-plus"></i></el-button>
          <el-button type="success" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit"></i></el-button>
          <el-popconfirm
              class="ml-5"
              confirm-button-text='确定'
              cancel-button-text='我再想想'
              icon="el-icon-info"
              icon-color="red"
              title="您确定删除吗？"
              @confirm="handleDelete(scope.row.id)">
            <el-button type="danger" slot="reference">删除<i class="el-icon-remove-outline"></i></el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="菜单信息" :visible.sync="dialogFormVisible" width="30%" >
      <el-form label-width="80px" size="small">
        <el-form-item label="名称" ><el-input v-model="form.name" autocomplete="off"></el-input></el-form-item>
        <el-form-item label="路径" ><el-input v-model="form.path" autocomplete="off"></el-input></el-form-item>
<!--        <el-form-item label="图标" ><el-input v-model="form.icon" autocomplete="off"></el-input></el-form-item>-->
        <el-form-item label="描述" ><el-input v-model="form.description" autocomplete="off"></el-input></el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "User",
  data(){
    return {
      tableData: [],
      total:0,
      pageNum:1,
      pageSize:10,
      name:"",
      form:{},
      dialogFormVisible :false,
      multipleSelection:[],
      headerBg:'headerBg'
    }
  },
  created() {
    //请求分页查询
    this.load()
  },
  methods:{
    load() {
      this.request.get("/menu").then(res => {
        this.tableData=res.date
      })
    },
    //重置搜索按钮
    reset(){
      this.name=""
      this.load()
    },
    handAdd(){
      this.dialogFormVisible=true
      this.form={}
    },
    //新增,编辑用户
    save(){
      this.request.post("/menu",this.form).then(res =>{
        if (res){
          this.$message.success("保存成功")
          this.dialogFormVisible= false
          this.load()
        }else {
          this.$message.error("保存失败")
        }
      })
    },
    //编辑用户
    handleEdit(row){
      this.form=row
      this.dialogFormVisible=true
    },
    //删除用户
    handleDelete(id){
      this.request.delete("/menu/"+id).then(res => {
        if (res){
          this.$message.success("删除成功")
          this.load()
        }else {
          this.$message.error("删除失败")
        }
      })
    },
    //批量删除
    handleSelectionChange(val){
      console.log(val)
      this.multipleSelection=val
    },
    delBatch(){
      let ids = this.multipleSelection.map(v => v.id)
      this.request.post("/menu/del/batch",ids).then(res => {
        if (res){
          this.$message.success("批量删除成功")
          this.load()
        }else {
          this.$message.error("批量删除失败")
        }
      })
    },
  }
}
</script>

<style scoped>

</style>

<style>
.headerBg{
  background: #eee!important;
}
</style>