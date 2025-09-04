<script setup>
import { onMounted, ref  } from 'vue';
import { queryAllApi } from '@/api/clazz';
import { queryPageApi, addApi, queryInfoApi, updateApi, updateViolationApi, deleteApi } from '@/api/stu';
import { ElMessage, ElMessageBox } from 'element-plus';

onMounted(() => {
  search();
  queryAllClazzs();
});
/* ======================================表单搜索 */
// 创建搜索表单数据对象
const searchForm = ref({
  name: '', 
  degree: '',
  clazzId: ''
});
const degrees = ref([{ name: '初中', value: 1 },{ name: '高中', value: 2 },{ name: '大专', value: 3 },{ name: '本科', value: 4 },{ name: '硕士', value: 5 },{ name: '博士', value: 6 }]);
const clazzs = ref([]);
// 查询所有班级信息
const queryAllClazzs = async () => {
  const result = await queryAllApi();
  if (result.code) {
    clazzs.value = result.data;
  }
};
// 分页查询按钮
const search = async () => {
  const result = await queryPageApi(
    searchForm.value.name, 
    searchForm.value.degree, 
    searchForm.value.clazzId, 
    currentPage.value, 
    pageSize.value
  );

  if (result.code) {
    total.value = result.data.total;
    stuList.value = result.data.rows;
  }
}

// 清空按钮
const clear = () => {
  searchForm.value.name = '';
  searchForm.value.degree = '';
  searchForm.value.clazzId = '';
  search();
}

/* ======================================添加学员/批量删除按钮 */
// 添加学员按钮
const add = () => {
  dialogVisible.value = true;
  dialogTitle.value = '添加学员';
  student.value = {
    name: '', 
    no: '',
    gender: '',
    phone: '',
    idCard: '',
    isCollege: '',
    address: '',
    degree: '',
    graduationDate: '',
    clazzId: ''
  };

  // 重置表单的校验规则-提示信息
  if (stuFormRef.value) {
    stuFormRef.value.resetFields();
  }
}

// 记录勾选的学员id
const selectionIds = ref([]);

// 处理点击复选框时触发-批量删除
const handleSelectionChange = (selection) => {
  selectionIds.value = selection.map(item => item.id);
} 

// 批量删除
const deleteByIds = async () => {
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

/* ======================================数据表格 */
// 创建stuList
const stuList = ref([]);
// 编辑按钮
const edit = async (id) => {
  const result = await queryInfoApi(id);
  if (result.code) {
    dialogVisible.value = true;
    dialogTitle.value = '编辑学员';
    student.value = result.data;
  }

  // 重置表单的校验规则-提示信息
  if (stuFormRef.value) {
    stuFormRef.value.resetFields();
  }
}

// 违纪按钮
const violation = async (id) => {
  violationForm.value.id = id;
  violationForm.value.score = null;
  dialogVisible_vio.value = true;
  dialogTitle_vio.value = '违纪处理';

  // 重置表单的校验规则-提示信息
  if (vioFormRef.value) {
    vioFormRef.value.resetFields();
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

/* ======================================分页条 */
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

/* ======================================添加/修改学员对话框 */
const dialogVisible = ref(false);
const dialogTitle = ref('');
const student = ref({
  name: '', 
  no: '',
  gender: '',
  phone: '',
  idCard: '',
  isCollege: '',
  address: '',
  degree: '',
  graduationDate: '',
  clazzId: ''
});

const genders = ref([{ name: '男', value: 1 },{ name: '女', value: 2 }]);
const colleges = ref([{ name: '是', value: 1 },{ name: '否', value: 0 }]);

// 保存按钮
const save = async () => {
  // 表单校验
  if (!stuFormRef.value) return;
  stuFormRef.value.validate(async (valid) => {
    // valid表示表单校验是否通过 true 通过 / false 不通过
    if (valid) { // 表单校验通过

      let result;
      if (student.value.id) { // 修改
        result = await updateApi(student.value);
      } else { // 添加
        result = await addApi(student.value);
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
  });
}

// 表单校验对象
const stuFormRef = ref();

// 表单校验规则
const rules = ref({
  name: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
    { min: 2, max: 10, message: '学员姓名名长度应在2到10个字符之间', trigger: 'blur' }
  ],
  no: [
    { required: true, message: '请输入学号', trigger: 'blur' },
    { message: '学号长度应为10个字符', trigger: 'blur' }
  ],
  gender: [
    { required: true, message: '请选择性别', trigger: 'change' }
  ],
  phone: [
    { required: true, message: '请输入手机号', trigger: 'blur' },
    { pattern: /^1[3-9]\d{9}$/, message: '手机号码非法', trigger: 'blur' }
  ],
  idCard: [
    { required: true, message: '请输入身份证号', trigger: 'blur' },
    { pattern: /^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/, message: '身份证号号非法', trigger: 'blur' }
  ],
  isCollege: [
    { required: true, message: '请选择是否是 college', trigger: 'change' }
  ],
  address: [
    { message: '请输入地址', trigger: 'blur' },
    { min: 0, max: 100, message: '地址长度应在0到100个字符之间', trigger: 'blur' }
  ],
});

/* ======================================违纪处理对话框 */
const dialogVisible_vio = ref(false);
const dialogTitle_vio = ref();
const violationForm = ref({
  id: null,
  score: null
});

const vioFormRef = ref();
const rules_vio = ({
  score: [
    {required: true, message: '请输入扣分值', trigger: 'blur'}  
  ]
});

// 确认按钮
const confirm = async () => {
  if (!violationForm.value.score) {
    ElMessage.warning('请输入违纪扣分');
    return;
  }

  const result = await updateViolationApi(violationForm.value.id, violationForm.value.score);
  if (result.code) {
    ElMessage.success('处理成功');
    dialogVisible_vio.value = false;
    search();
  } else {
    ElMessage.error(result.msg);
  }
}
</script>

<template>
  <h1>学员管理</h1>

  <!-- 表单搜索 -->
  <div class="container">
    <!-- {{ searchForm }} -->
    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
      <el-form-item label="姓名">
        <el-input v-model="searchForm.name" placeholder="请输入班级名称" clearable />
      </el-form-item>
      <el-form-item label="最高学历">
        <el-select v-model="searchForm.degree" placeholder="请选择" style="width: 100%;">
          <el-option v-for="d in degrees" :key="d.value" :label="d.name" :value="d.value"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="所属班级">
        <el-select v-model="searchForm.clazzId" placeholder="请选择" style="width: 100%;">
          <el-option v-for="c in clazzs" :key="c.id" :label="c.name" :value="c.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="search" size="small">查询</el-button>
        <el-button type="info" @click="clear" size="small">清空</el-button>
      </el-form-item>
    </el-form>
  </div>

  <!-- 添加学员/批量删除按钮 -->
  <div class="container">
    <el-button type="primary" @click="add">+ 添加学员</el-button>
    <el-button type="primary" @click="deleteByIds">- 批量删除</el-button>
  </div>

  <!-- 表格数据 -->
  <div class="container">
    <el-table :data="stuList" border style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column prop="name" label="姓名" width="80" align="center" />
      <el-table-column prop="no" label="学号" width="100" align="center" />
      <el-table-column prop="clazzName" label="班级" width="150" align="center" />
      <el-table-column label="性别" width="60" align="center">
        <template #default="scope">
          {{ scope.row.gender == 1 ? '男' : '女' }}
        </template>
      </el-table-column>
      <el-table-column prop="phone" label="手机号" width="120" align="center" />
      <el-table-column prop="degree" label="最高学历" width="100" align="center">
        <template #default="scope">
          <span v-if="scope.row.degree == 1">初中</span>
          <span v-else-if="scope.row.degree == 2">高中</span>
          <span v-else-if="scope.row.degree == 3">大专</span>
          <span v-else-if="scope.row.degree == 4">本科</span>
          <span v-else-if="scope.row.degree == 5">硕士</span>
          <span v-else-if="scope.row.degree == 6">博士</span>
          <span v-else>其他</span>
        </template>
      </el-table-column>
      <el-table-column prop="violationCount" label="违纪次数" width="90" align="center" />
      <el-table-column prop="violationScore" label="违纪扣分" width="90" align="center" />
      <el-table-column prop="updateTime" label="最后操作事件" width="200" align="center" />
      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button type="primary" size="small" @click="edit(scope.row.id)"><el-icon>
              <Edit />
            </el-icon> 编辑</el-button>
          <el-button type="primary" size="small" @click="violation(scope.row.id)"><el-icon>
              <Edit />
            </el-icon> 违纪</el-button>
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

  <!-- 添加/修改学员对话框 -->
  <el-dialog v-model="dialogVisible" :title="dialogTitle">
    <el-form :model="student" :rules="rules" ref="stuFormRef" label-width="80px">
      <!-- 基本信息 -->
      <!-- 第一行 -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="student.name" placeholder="请输入姓名"></el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="学号" prop="no">
            <el-input v-model="student.no" placeholder="请输入学号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第二行 -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="性别" prop="gender">
            <el-select v-model="student.gender" placeholder="请选择" style="width: 100%;">
              <el-option v-for="g in genders" :key="g.value" :label="g.name" :value="g.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="手机号" prop="phone">
            <el-input v-model="student.phone" placeholder="请输入手机号"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第三行 -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="身份证号" prop="idCard">
            <el-input v-model="student.idCard" placeholder="请输入身份证号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="院校学员" prop="isCollege">
            <el-select v-model="student.isCollege" placeholder="请选择" style="width: 100%;">
              <el-option v-for="c in colleges" :key="c.value" :label="c.name" :value="c.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第四行 -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="联系地址" prop="address">
            <el-input v-model="student.address" placeholder="请输入联系地址"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="最高学历">
            <el-select v-model="student.degree" placeholder="请选择" style="width: 100%;">
              <el-option v-for="d in degrees" :key="d.value" :label="d.name" :value="d.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第五行 -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="毕业时间">
            <el-date-picker v-model="student.graduationDate" type="date" style="width: 100%;" placeholder="选择毕业时间"
              format="YYYY-MM-DD" value-format="YYYY-MM-DD"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所属班级">
            <el-select v-model="student.clazzId" placeholder="请选择" style="width: 100%;">
              <el-option v-for="c in clazzs" :key="c.id" :label="c.name" :value="c.id"></el-option>
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

  <!-- 违纪次数/违纪分数对话框 -->
  <el-dialog v-model="dialogVisible_vio" :title="dialogTitle_vio">
    <el-form :model="violationForm" :rules="rules_vio" ref="vioFormRef" label-width="80px">
      <el-form-item label="违纪扣分" prop="score">
        <el-input v-model.number="violationForm.score" placeholder="请输入违纪扣分"></el-input>
      </el-form-item>
    </el-form>

    <!-- 底部按钮 -->
    <template #footer>
      <span class="dialog-footer">
        <el-button type="primary" @click="confirm">确认</el-button>
        <el-button @click="dialogVisible_vio = false">取消</el-button>
      </span>
    </template>
  </el-dialog>  
</template>

<style scoped>
.container {
  margin-top: 25px;
}
</style>