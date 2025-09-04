<script setup>
import { ref, onMounted, watch } from 'vue';
import { queryPageApi, addApi, queryInfoApi, updateApi, deleteApi } from '@/api/clazz';
import { queryAllApi as queryAllEmpApi } from '@/api/emp';
import { ElMessage, ElMessageBox } from 'element-plus';

onMounted(() => {
  search();
  queryAllEmps();
});
/* ========================================搜索栏 */
// 搜索表单
const searchForm = ref({name: '', date: [], begin: '', end: ''});
// 查询方法
const search = async() => { 
  const result = await queryPageApi(
    searchForm.value.name,
    searchForm.value.begin,
    searchForm.value.end,
    currentPage.value,
    pageSize.value
  );

  if (result.code) {
    total.value = result.data.total;
    clazzList.value = result.data.rows;
  }
}

// 清除方法
const clear = () => {
  searchForm.value = {name: '', date: [], begin: '', end: ''};
  search();
}

// watch侦听
watch(() => searchForm.value.date, (newVal, oldVal) => {
  if (newVal.length == 2) {
    searchForm.value.begin = newVal[0];
    searchForm.value.end = newVal[1];
  } else {
    searchForm.value.begin = '';
    searchForm.value.end = '';
  }
});

/* ========================================================新增按钮 */
// 班级信息
const clazz = ref({
  name: '',
  room: '',
  beginDate: '',
  endDate: '',
  masterId: '',
  subject: ''
});
// 对话框
const dialogVisible = ref(false);
const dialogTitle = ref('');
// 新增按钮
const addClazz = () => {
  dialogVisible.value = true;
  dialogTitle.value = '新增班级';
  clazz.value = {
    name: '',
    room: '',
    beginDate: '',
    endDate: '',
    masterId: '',
    subject: ''
  };
  // 重置表单的校验规则-提示信息
  if (clazzFormRef.value) {
    clazzFormRef.value.resetFields();
  }
};

// 表单信息
const subjects = ref([{ name: 'Java', value: 1 },{ name: '前端', value: 2 },{ name: '大数据', value: 3 },{ name: 'Python', value: 4 },{ name: 'Go', value: 5 },{ name: '嵌入式', value: 6 }]);
const emps = ref([]);

// 查询所有员工信息
const queryAllEmps = async () => {
  const result = await queryAllEmpApi();
  if (result.code) {
    emps.value = result.data;
  }
}

// 保存班级信息
const save = async () => {
  // 表单校验
  if (!clazzFormRef.value) return;
  clazzFormRef.value.validate(async (valid) => {
    // valid表示表单校验是否通过 true 通过 / false 不通过
    if (valid) { // 表单校验通过

      let result;
      if(clazz.value.id) { // 修改
        result = await updateApi(clazz.value);
      } else { // 新增
        result = await addApi(clazz.value);
      }

      if (result.code) {
        ElMessage.success('保存成功');
        dialogVisible.value = false;
        search();
      } else {
        ElMessage.error(result.msg);
      }      
    } else { // 表单校验不通过
      ElMessage.error('表单校验不通过！');
    }
  })
}

// 表单校验
const clazzFormRef = ref();
// 表单校验规则
const rules = ({
  name: [
    { required: true, message: '请输入班级名称', trigger: 'blur' },
    { min: 4, max: 30, message: '班级名称非法', trigger: 'blur' }
  ],
  beginDate: [
    { required: true, message: '请选择开课时间', trigger: 'change' }
  ],
  endDate: [
    { required: true, message: '请选择结课时间', trigger: 'change' }
  ],
  subject:[
    { required: true, message: '请选择', trigger: 'change' }
  ]
});

/* ==========================================================数据表格 */
const clazzList = ref([]);
// 编辑按钮
const edit = async (id) => {
  const result = await queryInfoApi(id);
  if (result.code) {
    dialogVisible.value = true;
    dialogTitle.value = '编辑班级';
    clazz.value = result.data;
  }
}

// 删除按钮
const delById = async (ids) => {
  ElMessageBox.confirm('您确认要删除该员工吗?','提示', 
  {confirmButtonText: '确认', cancelButtonText: '取消', type: 'warning'})
  .then( async () => { // 确认
    const result = await deleteApi(ids);
    if (result.code) {
      ElMessage.success('删除成功');
      search();
    } else {
      ElMessage.error(result.msg || '删除失败');
    }
  }).catch(() => { // 取消
    ElMessage.info('已取消');
  })
}

/* ===========================================================分页条 */
const currentPage = ref(1) // 页码
const pageSize = ref(10) // 每页展示记录数
const background = ref(true) // 是否有背景颜色
const total = ref(0); // 总页数

// 每页展示记录数变化
const handleSizeChange = (val) => {
  search();
}

// 页码变化时触发
const handleCurrentChange = (val) => {
  search();
}
</script>

<template>
  <h1>班级管理</h1>

  <!-- 搜索栏 -->
  <div class="container">
    <!-- {{ searchForm }} -->
    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
      <el-form-item label="姓名">
        <el-input v-model="searchForm.name" placeholder="请输入班级名称" clearable />
      </el-form-item>
      <el-form-item label="结课时间">
        <el-date-picker v-model="searchForm.date" type="daterange" range-separator="到" start-placeholder="开始时间"
          end-placeholder="结束时间" value-format="YYYY-MM-DD" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="search" size="small">查询</el-button>
        <el-button type="info" @click="clear" size="small">清空</el-button>
      </el-form-item>
    </el-form>
  </div>

  <!-- 新增按钮 -->
  <div class="container">
    <el-button type="primary" @click="addClazz">+ 新增班级</el-button>
  </div>

  <!-- 表格 -->
  <div class="container">
    <el-table :data="clazzList" border style="width: 100%">
      <el-table-column type="index" label="序号" width="80" align="center" />
      <el-table-column prop="name" label="班级名称" width="200" align="center" />
      <el-table-column prop="room" label="班级教室" width="100" align="center" />
      <el-table-column prop="masterName" label="班主任" width="120" align="center" />
      <el-table-column prop="beginDate" label="开课时间" width="100" align="center" />
      <el-table-column prop="endDate" label="结课时间" width="100" align="center" />
      <el-table-column prop="status" label="状态" width="120" align="center" />
      <el-table-column prop="updateTime" label="最后操作时间" width="180" align="center" />
      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button type="primary" size="small" @click="edit(scope.row.id)"><el-icon>
              <Edit />
            </el-icon> 编辑</el-button>
          <el-button type="danger" size="small" @click="delById(scope.row.id)"><el-icon>
              <Delete />
            </el-icon> 删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

  <!-- 分页条 -->
  <div class="container">
    <el-pagination v-model:current-page="currentPage" v-model:page-size="pageSize"
      :page-sizes="[5, 10, 20, 30, 40, 50, 60, 100]" :background="background"
      layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
      @current-change="handleCurrentChange" />
  </div>

  <!-- 新增/修改班级对话框 -->
  <el-dialog v-model="dialogVisible" :title="dialogTitle">
    <el-form :model="clazz" :rules="rules" ref="clazzFormRef" label-width="80px">
      <!-- 基本信息 -->
      <!-- 第一行 -->
      <el-row :gutter="20">
        <el-col :span="20">
          <el-form-item label="班级名称" prop="name">
            <el-input v-model="clazz.name" placeholder="请输入班级名称"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第二行 -->
      <el-row :gutter="20">
        <el-col :span="20">
          <el-form-item label="班级教室">
            <el-input v-model="clazz.room" placeholder="请填写班级教室"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第三行 -->
      <el-row :gutter="20">
        <el-col :span="20">
          <el-form-item label="开课时间" prop="beginDate">
            <el-date-picker v-model="clazz.beginDate" type="date" placeholder="请选择开课时间"/>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第四行 -->
      <el-row :gutter="20">
        <el-col :span="20">
          <el-form-item label="结课时间" prop="endDate">
            <el-date-picker v-model="clazz.endDate" type="date" placeholder="请选择结课时间"/>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第五行 -->
      <el-row :gutter="20">
        <el-col :span="20">
          <el-form-item label="班主任">
            <el-select v-model="clazz.masterId" placeholder="请选择" style="width: 100%;">
              <el-option v-for="e in emps" :key="e.id" :label="e.name" :value="e.id"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第六行 -->
      <el-row :gutter="20">
        <el-col :span="20">
          <el-form-item label="学科" prop="subject">
            <el-select v-model="clazz.subject" placeholder="请选择" style="width: 100%;">
              <el-option v-for="s in subjects" :key="s.value" :label="s.name" :value="s.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
      
    <!-- 底部按钮 -->
    <template #footer>
      <span class="dialog-footer">
        <el-button type="primary" @click="save">保存</el-button>
        <el-button @click="dialogVisible = false">取消</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<style scoped>
.container {
  margin-top: 25px;
}
</style>