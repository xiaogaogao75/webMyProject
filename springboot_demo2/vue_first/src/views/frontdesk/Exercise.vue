<template>
  <div>
    <div style="margin: 10px ">
      <el-table
          :size='size'
          :cell-style="{'font-size':fontSize}"
          :data="tableData"
          border
          style="width: 100%;">
        <el-table-column
            prop="date"
            label="数据结构"
            width="180">
        </el-table-column>
        <el-table-column
            prop="name"
            label="总题数"
            width="180">
        </el-table-column>
        <el-table-column
            prop="address"
            label="练习人数"
            width="180">
        </el-table-column>
        <el-table-column
            :cell-style="{'font-size':'15px'}"
            label="请注意"
            width="260">所有题目均随机抽取
        </el-table-column>
        <el-table-column
            label="操作">
          <el-button type="primary" size="medium"  @click="$router.push('/groupexercise')" style="margin-left: 50px">进入</el-button>
        </el-table-column>

      </el-table>
    </div>
    <div style="margin: 10px ">
      <el-table
          :size='size'
          :cell-style="{'font-size':fontSize}"
          :data="tableData"
          border
          style="width: 100%;">
        <el-table-column
            prop="date"
            label="数据结构"
            width="180">
        </el-table-column>
        <el-table-column
            prop="name"
            label="总题数"
            width="180">
        </el-table-column>
        <el-table-column
            prop="address"
            label="练习人数"
            width="180">
        </el-table-column>
        <el-table-column
            :cell-style="{'font-size':'15px'}"
            label="请注意"
            width="260">所有题目均随机抽取
        </el-table-column>
        <el-table-column
            label="操作">
          <el-button type="primary" size="medium"  @click="$router.push('/groupexercise')" style="margin-left: 50px">进入</el-button>
        </el-table-column>

      </el-table>
    </div>


  </div>
</template>

<script>
export default {
  name: "Exercise",
  data() {
    return {
      size: 'medium', fontSize: '25px',
      tableData: [{
        date: '基础算法',
        name: '2015',
        address: '123'
      }, {
        date: '树',
        name: '648',
        address: '321'
      }, {
        date: '链表',
        name: '1031',
        address: '456'
      }, {
        date: '栈',
        name: '656',
        address: '789'
      }]
    }
  }
}
</script>

<style scoped>

</style>