<template>
  <div>
    <div style="margin-bottom: 30px">
      <el-breadcrumb separator="/" >
        <el-breadcrumb-item :to="{path:'/root'}">首页</el-breadcrumb-item>
        <el-breadcrumb-item >权限管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div style="margin: 10px 0">
      <el-input style="width: 200px" suffix-icon="el-icon-search" placeholder="请输入名称" v-model="name"></el-input>
      <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
      <el-button  type="warning" @click="reset">重置</el-button>
    </div>
    <div style="margin: 10px 0">
      <el-button type="primary" @click="handadd">新增<i class="el-icon-circle-plus-outline"></i></el-button>
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
<!--      <el-upload-->
<!--          action="http://localhost:9091/user/import" :show-file-list="false" accept="'xls'" :on-success="handleImportSuccess" style="display: inline-block">-->
<!--      <el-button type="primary"  >导入<i class="el-icon-bottom"></i></el-button>-->
<!--      </el-upload>-->
<!--      <el-button type="primary" @click="exp" style="margin-left: 10px">导出<i class="el-icon-top"></i></el-button>-->
    </div>
    <el-table :data="tableData" border stripe :header-cell-class-name="headerBg" @selection-change="handleSelectionChange">
      <el-table-column type="selection" ></el-table-column>
      <el-table-column prop="id" label="ID" width="80px" ></el-table-column>
      <el-table-column prop="name" label="名称" ></el-table-column>
      <el-table-column prop="flag" label="唯一标识" ></el-table-column>
      <el-table-column prop="description" label="描述" ></el-table-column>
      <el-table-column  label="操作" width="280px">
        <template v-slot="scope">
          <el-button type="info" @click="selectMenu(scope.row.id)">权限菜单<i class="el-icon-menu"></i></el-button>
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
    <div style="  padding: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[10, 5, 15, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>
    <el-dialog title="权限信息" :visible.sync="dialogFormVisible" width="30%" >

      <el-form label-width="80px" size="small">
        <el-form-item label="名称" ><el-input v-model="form.name" autocomplete="off"></el-input></el-form-item>
        <el-form-item label="唯一标识" ><el-input v-model="form.flag" autocomplete="off"></el-input></el-form-item>
        <el-form-item label="描述" ><el-input v-model="form.description" autocomplete="off"></el-input></el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>
    <el-dialog title="权限分配" :visible.sync="menuDialogVis" width="30%" >
      <el-tree
          :props="props"
          :data="menuData"
          show-checkbox
          ref="tree"
          node-key="id"
          :default-expanded-keys="expends"
          :default-checked-keys="checks">
      </el-tree>
      <div slot="footer" class="dialog-footer">
        <el-button @click="menuDialogVis = false">取 消</el-button>
        <el-button type="primary" @click="saveRoleMenu">确 定</el-button>
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
      menuDialogVis:false,
      multipleSelection:[],
      headerBg:'headerBg',
      menuData:[],
      props:{
        label:'name'
      },
      roleId:0,
      checks:[],
      expends:[]

    }
  },
  created() {
    //请求分页查询
    this.load()
  },
  methods:{
    load() {
      this.request.get("/role/page?pageNum="+this.pageNum
          +"&pageSize="+this.pageSize+"&name="+this.name).then(res => {
        this.tableData=res.date.records
        this.total=res.date.total
      })

    },
    //重置搜索按钮
    reset(){
      this.name=""
      this.load()
    },
    handadd(){
      this.dialogFormVisible=true
      this.form={}
    },
    //新增,编辑用户
    save(){
      this.request.post("/role",this.form).then(res =>{
        if (res){
          this.$message.success("保存成功")
          this.dialogFormVisible= false
          this.load()
        }else {
          this.$message.error("保存失败")
        }
      })
    },
    saveRoleMenu(){
      this.request.post("/role/roleMenu/"+ this.roleId,this.$refs.tree.getCheckedKeys()).then(res =>{
        if (res.code==='200'){
          this.$message.success("绑定成功")
          this.menuDialogVis= false
          this.load()
        }else {
          this.$message.error("绑定失败")
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
      this.request.delete("/role/"+id).then(res => {
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
      this.request.post("/role/del/batch",ids).then(res => {
        if (res){
          this.$message.success("批量删除成功")
          this.load()
        }else {
          this.$message.error("批量删除失败")
        }
      })
    },
    //分页查询
    handleSizeChange(pageSize){
      console.log(pageSize)
      this.pageSize=pageSize
      this.load()
    },
    handleCurrentChange(pageNum){
      console.log(pageNum)
      this.pageNum=pageNum
      this.load()
    },
    //权限分配
    selectMenu(roleId){
      this.menuDialogVis=true
      this.roleId=roleId
      this.request.get("/menu",{
        params:{
          name:''
        }
      }).then(res => {
        this.menuData=res.date

      })
      this.request.get("/role/roleMenu/"+roleId).then(res =>{
        this.checks = res.date
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