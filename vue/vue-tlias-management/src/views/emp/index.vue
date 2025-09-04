<script setup>
import { onMounted, ref, watch } from 'vue';
import { queryPageApi, addApi, queryInfoApi, updateApi, deleteApi } from '@/api/emp';
import { queryAllApi as queryAllDeptApi } from '@/api/dept';
import { ElMessage, ElMessageBox } from 'element-plus';

// token
const token = ref();

// 获取token
const getToken = () => {
  const userLogin = JSON.parse(localStorage.getItem('userLogin'));
  if (userLogin && userLogin.token) {
    token.value = userLogin.token;
  }
}

// 钩子函数
onMounted(() => {
  getToken();
  search(); // 查询所有员工列表信息
  queryAllDepts(); // 查询所有部门列表
})

/* 表单搜索对象 */
const searchForm = ref({name: '', gender: '', date: [], begin: '', end: ''});

// 查询员工列表方法
const search = async () => {
  const result = await queryPageApi(
    searchForm.value.name,
    searchForm.value.gender,
    searchForm.value.begin,
    searchForm.value.end,
    currentPage.value,
    pageSize.value,
  );

  if (result.code) {
    total.value = result.data.total;
    empList.value = result.data.rows;
  }
}

// 清空方法
const clear = () => {
  searchForm.value = {name: '', gender: '', date: [], begin: '', end: ''};
  search();
}

// watch侦听searchForm中的date属性
watch(() => searchForm.value.date, (newVal, oldVal) => {
  if (newVal.length == 2) {
    searchForm.value.begin = newVal[0];
    searchForm.value.end = newVal[1];
  } else {
    searchForm.value.begin = '';
    searchForm.value.end = '';
  }
})

/* ============================================功能按钮 */
// 新增员工
const addEmp = () => {
  dialogVisible.value = true;
  dialogTitle.value = '新增员工';
  employee.value = {
    username: '',
    name: '',
    gender: '',
    phone: '',
    job: '',
    salary: '',
    deptId: '',
    entryDate: '',
    image: '',
    exprList: []
  };

  // 重置表单的校验规则-提示信息
  if (empFormRef.value) {
    empFormRef.value.resetFields();
  }
}

// 记录勾选的员工id
const selectionIds = ref([]);

// 复选框勾选发生变化时触发 - selection: 当前选中的数据（数组）
const handleSelectionChange = (selection) => {
  selectionIds.value = selection.map(item => item.id);
}

// 删除员工
const delById = async () => {
  ElMessageBox.confirm('您确认要删除该员工吗?','提示', 
  {confirmButtonText: '确认', cancelButtonText: '取消', type: 'warning'})
  .then( async () => { // 确认
    if (selectionIds.value && selectionIds.value.length > 0) {
      const result = await deleteApi(selectionIds.value);
      if (result.code) {
        ElMessage.success('删除成功');
        search();
      } else {
        ElMessage.error(result.msg || '删除失败');
      }
    } else {
      ElMessage.warning('请选择要删除的员工');
    }
  }).catch(() => { // 取消
    ElMessage.info('已取消');
  })
}

/* =====================================================表格数据 */
// 员工列表
const empList = ref([]);
// 编辑按钮
const edit = async (id) => {
  const result = await queryInfoApi(id);
  if (result.code) {
    dialogTitle.value = '编辑员工';
    dialogVisible.value = true;
    employee.value = result.data;

    // 对工作尽力做进一步的处理
    let exprList = employee.value.exprList;
    if (exprList && exprList.length > 0) {
      exprList.forEach((expr) => {
        expr.exprDate = [expr.begin, expr.end];
      })
    }
  }
}

// 删除员工
const deleteById = async (ids) => {
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

/* ========================================================分页条 */
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

/* ====================================================新增/修改表单 */
//职位列表数据
const jobs = ref([{ name: '班主任', value: 1 },{ name: '讲师', value: 2 },{ name: '学工主管', value: 3 },{ name: '教研主管', value: 4 },{ name: '咨询师', value: 5 },{ name: '其他', value: 6 }])
//性别列表数据
const genders = ref([{ name: '男', value: 1 }, { name: '女', value: 2 }])
// 部门信息列表
const depts = ref([]);

// 查询所有部门信息
const queryAllDepts = async () => {
  const result = await queryAllDeptApi();
  if (result.code) {
    depts.value = result.data;
  }
}

// 员工信息
const employee = ref({
  username: '',
  name: '',
  gender: '',
  phone: '',
  job: '',
  salary: '',
  deptId: '',
  entryDate: '',
  image: '',
  exprList: []
})
 
// 控制弹窗
const dialogVisible = ref(false)
const dialogTitle = ref('新增员工')
 
//文件上传
// 图片上传成功后触发
const handleAvatarSuccess = (response) => {
  employee.value.image = response.data;
}
// 文件上传之前触发
const beforeAvatarUpload = (rawFile) => {
  if (rawFile.type !== 'image/jpeg' && rawFile.type !== 'image/png') {
    ElMessage.error('只支持上传图片')
    return false
  } else if (rawFile.size / 1024 / 1024 > 10) {
    ElMessage.error('只能上传10M以内图片')
    return false
  }
  return true
}

// 添加工作经历
const addExprItem = () => {
  employee.value.exprList.push({company: '', job: '', begin: '', end: '', exprDate: []});
}

// 删除工作经历
const delExprItem = (index) => {
  employee.value.exprList.splice(index, 1);
}

// watch侦听-employee员工对象中的工作信息
watch(() => employee.value.exprList, (newVal, oldVal) => {
  if (employee.value.exprList && employee.value.exprList.length > 0) {
    employee.value.exprList.forEach((expr) => {
      expr.begin = expr.exprDate[0];
      expr.end = expr.exprDate[1];
    });
  }
}, {deep: true}); // 对数组中的元素进行侦听时，需要深度侦听

// 保存员工信息
const save = async () => {
  // 表单校验
  if (!empFormRef.value) return;
  empFormRef.value.validate(async (valid) => {
    // valid表示表单校验是否通过 true 通过 / false 不通过
    if (valid) { // 表单校验通过

      let result;
      if (employee.value.id) { // 修改
        result = await updateApi(employee.value);
      } else { // 新增
        result = await addApi(employee.value);
      }
      
      if (result.code) { // 成功
        ElMessage.success('保存成功');
        dialogVisible.value = false;
        search();
      } else {
        ElMessage.error(result.msg);
      }
    } else { // 表单校验不通过
      ElMessage.error('表单校验不通过！');
    }
  });
}

// 创建表单校验对象 -- 通过响应式对象获取当前表单
const empFormRef = ref();

// 表单校验规则
const rules = ref({
  username: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
    { min: 2, max: 20, message: '用户名长度应在2到20个字符之间', trigger: 'blur' }
  ],
  name: [
    { required: true, message: '请输入姓名', trigger: 'blur' },
    { min: 2, max: 10, message: '姓名长度应在2到10个字符之间', trigger: 'blur' }
  ],
  gender: [
    { required: true, message: '请选择性别', trigger: 'change' }
  ],
  phone: [
    { required: true, message: '请输入手机号', trigger: 'blur' },
    { pattern: /^1[3-9]\d{9}$/, message: '请输入有效的手机号', trigger: 'blur' }
  ]
});
</script>

<template>
  <h1>员工管理</h1>
  <!-- 搜索栏 -->
  <div class="container">
    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
      <el-form-item label="姓名">
        <el-input v-model="searchForm.name" placeholder="请输入员工姓名" clearable />
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="searchForm.gender" placeholder="请选择" clearable>
          <el-option label="男" value="1" />
          <el-option label="女" value="2" />
        </el-select>
      </el-form-item>
      <el-form-item label="入职日期">
        <el-date-picker v-model="searchForm.date" type="daterange" range-separator="到" start-placeholder="开始日期"
          end-placeholder="结束日期" value-format="YYYY-MM-DD" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="search" size="small">查询</el-button>
        <el-button type="info" @click="clear" size="small">清空</el-button>
      </el-form-item>
    </el-form>
  </div>

  <!-- 按钮 -->
  <div class="container">
    <el-button type="primary" @click="addEmp">+ 新增</el-button>
    <el-button type="danger" @click="delById">- 删除</el-button>
  </div>

  <!-- 数据展示表格 -->
  <div class="container">
    <el-table :data="empList" border style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column prop="name" label="姓名" width="120" align="center" />
      <el-table-column label="性别" width="120" align="center">
        <template #default="scope">
          {{ scope.row.gender == 1 ? '男' : '女' }}
        </template>
      </el-table-column>
      <el-table-column prop="image" label="头像" width="120" align="center">
        <template #default="scope">
          <img :src="scope.row.image" height="60">
        </template>
      </el-table-column>
      <el-table-column prop="deptName" label="所属部门" width="120" align="center" />
      <el-table-column prop="job" label="职位" width="120" align="center">
        <template #default="scope">
          <span v-if="scope.row.job == 1">班主任</span>
          <span v-else-if="scope.row.job == 2">讲师</span>
          <span v-else-if="scope.row.job == 3">学工主管</span>
          <span v-else-if="scope.row.job == 4">教研主管</span>
          <span v-else-if="scope.row.job == 5">咨询师</span>
          <span v-else>其他</span>
        </template>
      </el-table-column>
      <el-table-column prop="entryDate" label="入职日期" width="180" align="center" />
      <el-table-column prop="updateTime" label="最后操作事件" width="200" align="center" />
      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button type="primary" size="small" @click="edit(scope.row.id)"><el-icon>
              <Edit />
            </el-icon> 编辑</el-button>
          <el-button type="danger" size="small" @click="deleteById(scope.row.id)"><el-icon>
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

  <!-- 新增/修改员工的对话框 -->
  <el-dialog v-model="dialogVisible" :title="dialogTitle">
    <el-form :model="employee" :rules="rules" ref="empFormRef" label-width="80px">
      <!-- 基本信息 -->
      <!-- 第一行 -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="employee.username" placeholder="请输入员工用户名，2-20个字"></el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="employee.name" placeholder="请输入员工姓名，2-10个字"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第二行 -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="性别" prop="gender">
            <el-select v-model="employee.gender" placeholder="请选择性别" style="width: 100%;">
              <el-option v-for="g in genders" :key="g.value" :label="g.name" :value="g.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="手机号" prop="phone">
            <el-input v-model="employee.phone" placeholder="请输入员工手机号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第三行 -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="职位">
            <el-select v-model="employee.job" placeholder="请选择职位" style="width: 100%;">
              <el-option v-for="j in jobs" :key="j.value" :label="j.name" :value="j.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="薪资">
            <el-input v-model="employee.salary" placeholder="请输入员工薪资"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第四行 -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="所属部门">
            <el-select v-model="employee.deptId" placeholder="请选择部门" style="width: 100%;">
              <el-option v-for="d in depts" :key="d.id" :label="d.name" :value="d.id"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="入职日期">
            <el-date-picker v-model="employee.entryDate" type="date" style="width: 100%;" placeholder="选择日期"
              format="YYYY-MM-DD" value-format="YYYY-MM-DD"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第五行 -->
      <el-row :gutter="20">
        <el-col :span="24">
          <el-form-item label="头像">
            <el-upload class="avatar-uploader" action="/api/upload" :headers="{'token': token}" :show-file-list="false"
              :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">
              <img v-if="employee.image" :src="employee.image" class="avatar" />
              <el-icon v-else class="avatar-uploader-icon">
                <Plus />
              </el-icon>
            </el-upload>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 工作经历 -->
      <!-- 第六行 -->
      <el-row :gutter="10">
        <el-col :span="24">
          <el-form-item label="工作经历">
            <el-button type="success" size="small" @click="addExprItem">+ 添加工作经历</el-button>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第七行 ...  工作经历 -->
      <el-row :gutter="3" v-for="(expr, index) in employee.exprList">
        <el-col :span="10">
          <el-form-item size="small" label="时间" label-width="80px">
            <el-date-picker type="daterange" v-model="expr.exprDate" range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期"
              format="YYYY-MM-DD" value-format="YYYY-MM-DD"></el-date-picker>
          </el-form-item>
        </el-col>

        <el-col :span="6">
          <el-form-item size="small" label="公司" label-width="60px">
            <el-input placeholder="请输入公司名称" v-model="expr.company"></el-input>
          </el-form-item>
        </el-col>

        <el-col :span="6">
          <el-form-item size="small" label="职位" label-width="60px">
            <el-input placeholder="请输入职位" v-model="expr.job"></el-input>
          </el-form-item>
        </el-col>

        <el-col :span="2">
          <el-form-item size="small" label-width="0px">
            <el-button type="danger" @click="delExprItem(index)">- 删除</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>

    <!-- 底部按钮 -->
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save">保存</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<style scoped>
.container {
  margin-top: 15px;
}

/* 新增/修改员工对话框 */
.avatar {
  height: 40px;
}
.avatar-uploader .avatar {
  width: 78px;
  height: 78px;
  display: block;
}
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}
 
.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}
 
.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 78px;
  height: 78px;
  text-align: center;
  border-radius: 10px;
  /* 添加灰色的虚线边框 */
  border: 1px dashed var(--el-border-color);
}
</style>