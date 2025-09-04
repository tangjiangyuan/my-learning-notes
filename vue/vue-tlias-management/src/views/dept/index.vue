<script setup>
import { onMounted, ref } from 'vue';
import { queryAllApi, addApi, queryByIdApi, updateApi, deleteByIdApi } from '@/api/dept';
import { ElMessage, ElMessageBox  } from 'element-plus';

const deptList = ref([])

/* 钩子函数 */
onMounted(() => {
  search();
})

/* 查询方法 */
const search = async () => {
  /* const result = await axios.get('https://m1.apifoxmock.com/m1/6986065-6703593-default/depts');
  // JS隐式类型转换 0 - false, 其它数字 - true; '' - false, 其它都是true; null, undefined -- false
  if (result.data.code){
    deptList.value = result.data.data;
  } */

  const result = await queryAllApi();
  if (result.code){
    deptList.value = result.data;
  }
}

/* dialog对话框 */
const dialogFormVisible = ref(false);
const dept = ref({name: ''});
const formTitle = ref('');

/* 新增按钮 */
const addDept = () => {
  // 将部门名字置为空串，不然再次点击新增按钮时，输入框中显现的是上一次的部门名字
  dept.value.name = '';
  dialogFormVisible.value = true;
  formTitle.value = '新增部门';
  // 重置表单的校验规则-提示信息
  if (deptFormRef.value) {
    deptFormRef.value.resetFields();
  }
};

/* 编辑按钮 */
const editDept = async (id) => {
  // 重置表单的校验规则-提示信息
  if (deptFormRef.value) {
    deptFormRef.value.resetFields();
  }
  formTitle.value = '编辑部门'; // formTitle是响应式的，所以修改值的时候要 .value
  const result = await queryByIdApi(id);
  if (result.code) {
    dialogFormVisible.value = true;
    dept.value = result.data; // 核心，数据回显
  }
}

/* 删除按钮 */
const delById = (id) => {
  ElMessageBox.confirm('您确认要删除吗?','提示', 
  {confirmButtonText: '确认', cancelButtonText: '取消', type: 'warning'})
  .then( async () => { // 确认
    const result = await deleteByIdApi(id);
    if (result.code) {
      ElMessage.success('删除成功');
      search();
    }
  }).catch(() => { // 取消
    ElMessage.info('已取消');
  })
}

/* 新增部门的方法 */
const save = async () => { 
  if (!deptFormRef.value) return;
  deptFormRef.value.validate( async (valid) => {
    // valid表示表单校验是否通过 true 通过 / false 不通过
    if (valid) { // 表单校验通过

      let result;
      if (dept.value.id) { // true -- 修改
        result = await updateApi(dept.value);
      } else { // false -- 新增
        result = await addApi(dept.value);
      }

      if (result.code) { // 成功
        // 给出新增成功的提示信息
        // alert('操作成功!');
        ElMessage.success('操作成功!');

        // 关闭对话框
        dialogFormVisible.value = false;

        // 调用查询方法
        search();
      } else { // 失败
        ElMessage.error(result.msg);
      }
    } else { // 表单校验不通过
      ElMessage.error('表单校验不通过！');
    }
  });
};

/* 表单校验 */
const rules = ref({
  name: [
    { required: true, message: '部门名称为必填项', trigger: 'blur' },
    { min: 2, max: 10, message: '部门名称应该在2-10位', trigger: 'blur' },
  ]
})

const deptFormRef = ref();
</script>

<template>
  <h1>部门管理</h1>
  <!-- 新增部门按钮 -->
  <div class="container">
    <el-button type="primary" @click="addDept"> + 新增部门</el-button>
  </div>

  <!-- 部门信息表格 -->
  <div class="container">
    <el-table :data="deptList" border style="width: 100%">
      <el-table-column type="index" label="序号" width="80" align="center" />
      <el-table-column prop="name" label="部门名称" width="200" align="center" />
      <el-table-column prop="updateTime" label="最后操作时间" width="320" align="center" />
      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button type="primary" size="small" @click="editDept(scope.row.id)"><el-icon>
              <Edit />
            </el-icon> 编辑</el-button>
          <el-button type="danger" size="small" @click="delById(scope.row.id)"><el-icon>
              <Delete />
            </el-icon> 删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

  <!-- dialog对话框 -->
  <el-dialog v-model="dialogFormVisible" :title="formTitle" width="500">
    <el-form :model="dept" :rules="rules" ref="deptFormRef">
      <el-form-item label="部门名称" label-width="80px" prop="name">
        <el-input v-model="dept.name"/>
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="save">确定</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<style scoped>
.container {
  margin-top: 15px;
  margin-right: 350px;
}
</style>
