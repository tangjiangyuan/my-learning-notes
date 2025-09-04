<script setup>
  import { onMounted, ref } from 'vue'
  import axios from 'axios'

/* form表单 */
const emp = ref({
  name: '',
  gender: '',
  job: ''
})

/* 查询方法 */
const search = async () => {
  const result = await axios.get(`https://web-server.itheima.net/emps/list?name=${emp.value.name}&gender=${emp.value.gender}&job=${emp.value.job}`)
  empList.value = result.data.data;
}
/* 清空方法 */
const clear = () => {
  emp.value = { name: '', gender: '', job: '' },
  search()
}
/* 钩子函数 */
onMounted(() => {
  search()
})

/* 表格数据 */
const empList = ref([])
</script>

<template>
  <!-- 员工列表查询 -->
  <div id="container">
    <!-- 搜索表单 -->
    <el-form :inline="true" :model="emp" class="demo-form-inline">
      <el-form-item label="姓名">
        <el-input v-model="emp.name" placeholder="请输入姓名" clearable />
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="emp.gender" placeholder="请选择" clearable>
          <el-option label="男" value="1" />
          <el-option label="女" value="0" />
        </el-select>
      </el-form-item>
      <el-form-item label="职位">
        <el-select v-model="emp.job" placeholder="请选择" clearable>
          <el-option label="班主任" value="1" />
          <el-option label="讲师" value="2" />
          <el-option label="学工主管" value="3" />
          <el-option label="教研主管" value="4" />
          <el-option label="咨询师" value="5" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="search">查询</el-button>
        <el-button type="info" @click="clear">清空</el-button>
      </el-form-item>
    </el-form>

    <!-- 表格数据 -->
    <el-table :data="empList" border style="width: 100%">
      <el-table-column prop="id" label="ID" width="100" align="center"/>
      <el-table-column prop="name" label="姓名" width="100" align="center"/>
      <el-table-column prop="image" label="头像" width="180" align="center">
        <!-- 自定义列模板 -->
        <template #default="scope">
          <img :src="scope.row.image" height="70px"/>
        </template>
      </el-table-column>
      <el-table-column label="性别" width="180" align="center">
        <template #default="scope">
          {{ scope.row.gender === 1 ? '男' : '女' }}
        </template>
      </el-table-column>
      <el-table-column prop="job" label="职位" width="180" align="center">
        <template #default="scope">
          <span v-if="scope.row.job == 1">班主任</span>
          <span v-else-if="scope.row.job == 2">讲师</span>
          <span v-else-if="scope.row.job == 2">学工主管</span>
          <span v-else-if="scope.row.job == 2">教研主管</span>
          <span v-else-if="scope.row.job == 2">咨询师</span>
          <span v-else>其它</span>
        </template>
      </el-table-column>
      <el-table-column prop="entrydate" label="入职日期" width="180" align="center"/>
      <el-table-column prop="updatetime" label="更新时间" align="center"/>
    </el-table>
  </div>
</template>

<style scoped>
#container {
  width: 70%;
  margin-left: 15%;
  margin-right: 15%;
}

.demo-form-inline {
  margin-bottom: 20px;
}
</style>