## part5：前端Web实战

## 一、Vue工程化

### 1.介绍

![image-20250819172019016](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819172019016.png)

===渐进式

![image-20250819172141219](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819172141219.png)

### 2、引言

![image-20250819172414670](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819172414670.png)

#### 2.1如何解决呢？

![image-20250819172529986](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819172529986.png)

#### 2.2、前端工程化

![image-20250819172625148](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819172625148.png)

### 3、准备工作

（1）介绍

​		create-vue 是Vue官方提供的最新脚手架工具，用于快速生成一个工程化的Vue项目。

（2）create-vue 提供了如下功能：

- 统一的目录结构
- 本地部署
- 热部署
- 单元测试
- 继承打包上线

（3）依赖环境：NodeJS

（4）下载 NodeJS 并验证

![image-20250819184824873](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819184824873.png)

（5）npm

![image-20250819185437227](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819185437227.png)

（6）配置npm的全局安装路径

![image-20250819185238130](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819185238130.png)

```
npm config set prefix "D:\Dev-download\NodeJS"
```

（7）切换为淘宝镜像，加速下载

```
npm config set registry https://registry.npmmirror.com
```



### 4、Vue项目简介

#### 4.1、创建

![image-20250819185910016](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819185910016.png)

#### 4.2、依赖安装

![image-20250819190034369](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819190034369.png)

===演示

![image-20250819190218761](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819190218761.png)

![image-20250819190544881](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819190544881.png)

![image-20250819190555466](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819190555466.png)

![image-20250819190811020](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819190811020.png)

![image-20250819190900620](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819190900620.png)

===使用vsCode打开vue-project1

#### 4.3、项目结构

![image-20250819191311066](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819191311066.png)

#### 4.4、项目启动

![image-20250819191556167](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819191556167.png)

（1）方式一

![image-20250819191734599](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819191734599.png)

（2）方式二

![image-20250819192222153](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819192222153.png)

![image-20250819192206619](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819192206619.png)

===小结

![image-20250819192142677](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819192142677.png)

### 5、Vue项目开发流程

![image-20250819193346924](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819193346924.png)

![image-20250819193452502](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819193452502.png)

![image-20250819193747438](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819193747438.png)

==============================

![image-20250819194028687](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819194028687.png)

![image-20250819194047632](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819194047632.png)

===小结

![image-20250819194227106](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819194227106.png)

![image-20250819194304030](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819194304030.png)

### 6、API风格

#### 6.1、选项式API

![image-20250819194526189](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819194526189.png)

#### 6.2、组合式API

![image-20250819194742283](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819194742283.png)

![image-20250819194752461](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819194752461.png)

===细节

![image-20250819195141249](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819195141249.png)

![image-20250819195205589](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819195205589.png)

===运行写好的vue文件：在App.vue文件中引入ApiDemo.vue文件

![image-20250819200545109](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819200545109.png)

![image-20250819200636776](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250819200636776.png)

===小结

![image-20250820090648251](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820090648251.png)

### 7、案例

![image-20250820091402849](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820091402849.png)

![image-20250820091455122](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820091455122.png)

![image-20250820091556893](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820091556893.png)

===代码演示

```vue
<script setup>
import axios from 'axios';
import { onMounted, ref } from 'vue';

const name = ref('');
const gender = ref('');
const job = ref('');
const userList = ref([]);

/* 定义箭头函数 search */
const search = async () => {
  // 通过axios发起异步请求，请求服务区端的数据
  // 通过.value获取输入框中的数据
  await axios.get(`https://web-server.itheima.net/emps/list?name=${name.value}&gender=${gender.value}&job=${job.value}`).then((result) => {
    userList.value = result.data.data;
  }).catch((err) => {
    console.log(err);
  });
}
// 定义钩子函数
onMounted(() => {
  search();
});
</script>
```

![image-20250820093508575](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820093508575.png)

===小结

![image-20250820093346877](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820093346877.png)

## 二、ElementPlus

### 1、介绍

- Element：是饿了么团队研发的，基于 Vue3 ，面向设计师和开发者的组件库。
- 组件：组成网页的部件，例如：超链接、按钮、图片、表格、表单、分页条等。
- 官网：https://element-plus.org/zh-CN/

![image-20250820094121264](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820094121264.png)

### 2、快速入门

#### 2.1、步骤

![image-20250820094315102](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820094315102.png)

===演示

![image-20250820095133438](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820095133438.png)

![image-20250820095526377](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820095526377.png)

===代码演示

```vue
<script setup>

</script>

<template>
  <div class="mb-4">
    <el-button>Default</el-button>
    <el-button type="primary">Primary</el-button>
    <el-button type="success">Success</el-button>
    <el-button type="info">Info</el-button>
    <el-button type="warning">Warning</el-button>
    <el-button type="danger">Danger</el-button>
  </div>

  <div class="mb-4">
    <el-button plain>Plain</el-button>
    <el-button type="primary" plain>Primary</el-button>
    <el-button type="success" plain>Success</el-button>
    <el-button type="info" plain>Info</el-button>
    <el-button type="warning" plain>Warning</el-button>
    <el-button type="danger" plain>Danger</el-button>
  </div>
</template>

<style scoped>
.mb-4 {
  margin-bottom: 20px;
}
</style>
```

===说明：控制按钮颜色的type属性

===小结

![image-20250820100536725](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820100536725.png)

### 3、常见组件

#### 3.1、表格组件

![image-20250820102013804](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820102013804.png)

![image-20250820102025409](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820102025409.png)

===小结

![image-20250820102121482](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820102121482.png)

#### 3.2、分页条组件

![image-20250820102200769](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820102200769.png)



===补充

![image-20250820112424195](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820112424195.png)

![image-20250820112704667](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820112704667.png)

#### 3.3、对话框组件

![image-20250820143416549](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820143416549.png)

![image-20250820143439063](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820143439063.png)

===小结

![image-20250820143513981](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820143513981.png)

#### 3.4、表单组件

![image-20250820143607619](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820143607619.png)

![image-20250820150643351](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820150643351.png)

![image-20250820150657505](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820150657505.png)

![image-20250820150709486](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820150709486.png)

===小结

![image-20250820150851587](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820150851587.png)

### 4、案例

#### 4.1、需求

![image-20250820183419652](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820183419652.png)

#### 4.2、代码演示

```vue
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
        <template #default="scope">
          <img :src="scope.row.image" height="70px"/>
        </template>
      </el-table-column>
      <el-table-column label="性别" width="180" align="center">
      	<!-- 自定义列模板 -->
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
```



## 三、Tlias案例

### 1、开发模式

#### 1.1、开发流程

![image-20250820195356995](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820195356995.png)

#### 1.2、小结

![image-20250820195511847](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820195511847.png)

### 2、整体布局

![image-20250820195646491](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820195646491.png)

#### 2.1、准备工作

![image-20250820195819948](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820195819948.png)

![image-20250820201732007](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250820201732007.png)

#### 2.2、动态菜单

（1）Vue-Router介绍

![image-20250821093618049](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821093618049.png)

（2）组成

![image-20250821093902415](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821093902415.png)

（3）引入方式

![image-20250821094018344](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821094018344.png)

（4）修改左侧菜单栏

方式一：缺点：过于繁琐

![image-20250821094611938](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821094611938.png)

方式二：

![image-20250821095049569](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821095049569.png)

![image-20250821095228555](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821095228555.png)

![image-20250821095259919](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821095259919.png)

（5）修改路由Router实例

![image-20250821095652650](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821095652650.png)

===a

![image-20250821100234219](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821100234219.png)

===b：配置路由表

![image-20250821100756063](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821100756063.png)

===c：核心区域展示对应的页面

![image-20250821101256705](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821101256705.png)

![image-20250821101603148](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821101603148.png)

![image-20250821101630129](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821101630129.png)

===问题：如何解决登录页面展示在核心区域？

![image-20250821101737891](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821101737891.png)

===小结

![image-20250821101925304](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821101925304.png)

===d---解决登录页面

===原因：在路由表中配置了登录的路由，并在核心区域中展示

===解决：在根页面下添加登录路由

![image-20250821103052341](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821103052341.png)

![image-20250821110924503](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821110924503.png)

![image-20250821111231983](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821111231983.png)

===问题：不指定资源路由，页面什么数据都没有，如何在不访问任何资源路由时访问默认路由？

![image-20250821111556205](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821111556205.png)

![image-20250821111918225](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821111918225.png)

===小结

![image-20250821112227750](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821112227750.png)

### 3、部门管理

#### 3.1、列表查询

##### 3.1.1、页面布局

![image-20250821112740773](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821112740773.png)

##### 3.1.2、代码演示

![image-20250821142550856](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821142550856.png)

![image-20250821142656994](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821142656994.png)

##### 3.1.3、加载数据

![image-20250821142851053](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821142851053.png)

##### 3.1.4、使用Apifox

![image-20250821143744385](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821143744385.png)

![image-20250821143823520](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821143823520.png)

##### 3.1.5、规范响应的数据

![image-20250821144603712](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821144603712.png)

![image-20250821144640672](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821144640672.png)

##### 3.1.6、渲染页面

![image-20250821150300367](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821150300367.png)

##### 3.1.7、程序优化

![image-20250821150811034](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821150811034.png)

（1）思路

![image-20250821151259465](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821151259465.png)

![image-20250821151443153](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821151443153.png)

![image-20250821151541104](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821151541104.png)

（2）准备代码

![image-20250821152121236](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821152121236.png)

![image-20250821153138699](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821153138699.png)

![image-20250821152717926](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821152717926.png)

（3）修改代码

![image-20250821161132192](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821161132192.png)

（4）连接到tomcat服务器

===使用反向代理服务器

![image-20250821162009198](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821162009198.png)

===补充：/api是用来区分是否访问的是服务器端，访问静态资源不需要加入/api

启动服务器端

![image-20250821163839964](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821163839964.png)

![image-20250821163936875](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821163936875.png)

===问题：如果最后操作时间不是按照最后修改时间倒叙排序的，查看

![image-20250821164039469](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821164039469.png)

#### 3.2、新增部门

##### 3.2.1、分析

![image-20250821164951723](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821164951723.png)

##### 3.2.2、准备代码

![image-20250821172809775](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821172809775.png)

![image-20250821172822589](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821172822589.png)

===由于新增部门和编辑部门的对话框大致相同，所以新增部门按钮的名字不能写死了；当点击新增部门时，显示新增部门名字；当点击编辑按钮时，显示编辑部门名字。

![image-20250821184926588](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821184926588.png)

![image-20250821184958962](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821184958962.png)

##### 3.2.3、编写save方法

![image-20250821185317248](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821185317248.png)

===问题：每次点击新增部门按钮时，输入框都会显示上一次输入的部门名称，如何解决？

![image-20250821185830706](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821185830706.png)

##### 3.2.4、表单校验

![image-20250821191019221](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821191019221.png)

![image-20250821191321523](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821191321523.png)

![image-20250821193306501](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821193306501.png)

![image-20250821193335821](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821193335821.png)

===但是徒有其表，并没有规范部门名称

===解决

![image-20250821194630789](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821194630789.png)

修改save中的逻辑

![image-20250821195616912](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821195616912.png)

===补充：await只能出现在被 async修饰的函数中

![image-20250821195328365](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821195328365.png)

===问题：上次的表单校验规则出现在了现在的表单中

===解决：在点击新增部门按钮，删除表单校验规则

![image-20250821200413751](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821200413751.png)

===小结

![image-20250821201445143](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821201445143.png)

#### 3.3、修改部门

##### 3.3.1、思路

![image-20250821201708347](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250821201708347.png)

##### 3.3.2、数据回显

![image-20250822094818411](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822094818411.png)

![image-20250822095003365](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822095003365.png)

![image-20250822095137141](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822095137141.png)

===优化：解决---在编辑错误信息后，再次点击编辑按钮时仍会显示错误提示

![image-20250822095615193](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822095615193.png)

##### 3.3.3、修改

===思路：因为新增和编辑采用同一个对话框，点击确定按钮(执行save方法)时，根据id的有无来判断是执行新增操作，还是执行修改功能

![image-20250822101055166](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822101055166.png)

#### 3.4、删除部门

##### 3.4.1、思路

![image-20250822101255060](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822101255060.png)

##### 3.4.2、代码演示

![image-20250822141503800](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822141503800.png)

![image-20250822141642057](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822141642057.png)

![image-20250822141713496](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822141713496.png)

===注意：调用api中的方法前一定要先导入

![image-20250822141805509](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822141805509.png)

### 4、员工管理

#### 4.1、需求分析

![image-20250822142104782](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822142104782.png)

#### 4.2、条件分页查询

##### 4.2.1、页面布局

![image-20250822142341345](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822142341345.png)

##### 4.2.2、搜索栏

===补充：如果表单搜索的数据较多，可以封装到一个对象中。

![image-20250822150520004](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822150520004.png)

![image-20250822150538729](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822150538729.png)

##### （1）问题

![image-20250822150918149](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822150918149.png)

##### （2）watch侦听

![image-20250822151127222](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822151127222.png)

![image-20250822151955596](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822151955596.png)

![image-20250822151942347](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822151942347.png)

```js
// watch侦听 ------------- 演示
const a = ref('');
watch(a, (newVal, oldVal) => {
  console.log(`变化后的值:${newVal},变化前的值:${oldVal}`);
});
```



##### （3）watch侦听对象

![image-20250822153044237](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822153044237.png)

```js
// watch侦听对象全部属性 -----------------演示
const user = ref({name: '', age: 11});
watch(user, (newVal, oldVal) => {
  console.log(newVal);
}),{deep: true};
```



##### （4）watch侦听对象指定属性

![image-20250822160737308](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822160737308.png)

```js
// watch侦听指定属性 --------演示
const user = ref({name: '', age: 11});
watch(() => user.value.name, (newVal, oldVal) => {
  console.log(`变化后的值:${newVal},变化前的值:${oldVal}`);
})
```

##### （5）代码优化

![image-20250822162630084](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822162630084.png)

![image-20250822162450115](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822162450115.png)

##### （6）小结

![image-20250822163418900](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250822163418900.png)

##### 4.2.3、按钮

```vue
<!-- 按钮 -->
<div class="container">
    <el-button type="primary" @click="save">+ 新增</el-button>
    <el-button type="danger" @click="delByIds">- 删除</el-button>
</div>
```

![image-20250824182106036](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824182106036.png)

##### 4.2.4、数据展示格式

```vue
<!-- 数据展示表格 -->
  <div class="container">
    <el-table :data="empList" border style="width: 100%">
      <el-table-column type="selection" width="55" align="center"/>
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
          <el-button type="primary" size="small" @click=""><el-icon><Edit /></el-icon> 编辑</el-button>
          <el-button type="danger" size="small" @click=""><el-icon><Delete /></el-icon> 删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
```

![image-20250824181809503](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824181809503.png)

##### 4.2.5、分页条

![image-20250824181836737](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824181836737.png)

![image-20250824181850691](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824181850691.png)

##### 4.2.6、页面交互

##### （1）分析

![image-20250824182315799](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824182315799.png)

##### （2）查询员工列表---查询按钮

![image-20250824215950366](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824215950366.png)

![image-20250824220720209](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824220720209.png)

![image-20250824222103798](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824222103798.png)

##### （3）查询员工列表--分页组件

![image-20250824222356446](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824222356446.png)

![image-20250824222511878](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824222511878.png)

#### 4.3、新增员工

##### 4.3.1、页面布局

##### （1）页面分析

![image-20250824222914746](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824222914746.png)

##### （2）采用Layout布局展示对话框

![image-20250824224933879](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824224933879.png)

![image-20250824225037162](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824225037162.png)

===gutter设置列间距

![image-20250824225254665](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824225254665.png)

![image-20250824225336051](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824225336051.png)

##### （3）问题

===当前下拉列表的数据定义死了，不利于后期的维护和管理

![image-20250824225846991](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824225846991.png)

===动态绑定

![image-20250824233229908](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824233229908.png)

![image-20250824233657147](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824233657147.png)

![image-20250824233748704](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824233748704.png)

##### （4）展示部门信息下拉列表

![image-20250824234812488](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824234812488.png)

![image-20250824234839797](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824234839797.png)

![image-20250824234853951](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824234853951.png)

![image-20250824235227361](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824235227361.png)

![image-20250824235032222](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250824235032222.png)

##### （5）头像上传操作

===使用upload组件

![image-20250825090810741](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825090810741.png)

![image-20250825090954715](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825090954715.png)

![image-20250825091516719](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825091516719.png)

##### 4.3.2、页面交互

##### （1）添加工作经历

![image-20250825092602467](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825092602467.png)

![image-20250825093407685](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825093407685.png)

===通过遍历，动态展示

![image-20250825094142920](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825094142920.png)

##### （2）删除工作经历

![image-20250825094801488](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825094801488.png)

![image-20250825094927017](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825094927017.png)

![image-20250825100559199](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825100559199.png)

##### （3）保存员工

![image-20250825101003384](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825101003384.png)

![image-20250825102509776](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825102509776.png)

===保存成功之后，再次点击添加员工时，还存在着上一次添加员工的信息

![image-20250825102415959](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825102415959.png)

![image-20250825102707772](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825102707772.png)

##### （4）表单校验

![image-20250825110702873](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825110702873.png)

![image-20250825111314007](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825111314007.png)

![image-20250825111606959](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825111606959.png)

=========

![image-20250825112233640](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825112233640.png)

![image-20250825112900394](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825112900394.png)

![image-20250825113051741](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825113051741.png)

#### 4.4、修改员工

##### 4.4.1、分析

![image-20250825113900260](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825113900260.png)

##### 4.4.2、查询回显

![image-20250825114000008](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825114000008.png)

![image-20250825140857263](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825140857263.png)

![image-20250825143454322](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825143454322.png)

![image-20250825143612896](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825143612896.png)

##### 4.4.3、修改

![image-20250825144708227](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825144708227.png)

```js
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
```



#### 4.5、删除员工

##### 4.5.1、分析

![image-20250825145041098](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825145041098.png)

##### 4.5.2、单个删除

![image-20250825145142682](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825145142682.png)

![image-20250825160447549](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825160447549.png)

##### 4.5.3、批量删除

![image-20250825160615441](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825160615441.png)

![image-20250825162116716](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250825162116716.png)

### 5、班级管理

### 6、学员管理

### 7、登录退出

#### 7.1、分析

![image-20250826183852189](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826183852189.png)

#### 7.2、登录操作

![image-20250826185617240](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826185617240.png)

![image-20250826190700303](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826190700303.png)

#### 7.3、问题与解决

![image-20250826190921063](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826190921063.png)

![image-20250826191735250](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826191735250.png)

![image-20250826191836062](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826191836062.png)

#### 7.4、携带令牌访问服务器端

![image-20250826192528702](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826192528702.png)

![image-20250826192617207](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826192617207.png)

![image-20250826193817580](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826193817580.png)

#### 7.5、解决文件上传的问题

===大部分请求都是通过request，但有一个不是，就是文件上传

![image-20250826193952444](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826193952444.png)

![image-20250826194232111](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826194232111.png)

![image-20250826194505787](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826194505787.png)

![image-20250826195142943](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826195142943.png)

#### 7.6、响应401时-跳转登陆页面

![image-20250826195456774](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826195456774.png)

![image-20250826195702817](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826195702817.png)

![image-20250826200523765](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826200523765.png)

![image-20250826200708506](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826200708506.png)

#### 7.7、退出-分析

![image-20250826201243765](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826201243765.png)

#### 7.8、退出-展示当前用户名

![image-20250826201511533](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826201511533.png)

![image-20250826202132031](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826202132031.png)

![image-20250826202155148](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250826202155148.png)

#### 7.9、退出登录

![image-20250827090929774](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250827090929774.png)

### 8、打包部署

#### 8.1、打包

![image-20250827201515698](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250827201515698.png)

#### 8.2、部署

![image-20250827201928342](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250827201928342.png)

![image-20250828192128619](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250828192128619.png)

![image-20250828192218422](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250828192218422.png)

===问题：启动nginx后，打开页面显示接口无法访问问题？

![image-20250828192742738](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250828192742738.png)

![image-20250828193142183](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250828193142183.png)

![image-20250828193215453](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250828193215453.png)

![image-20250828193335506](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250828193335506.png)

===停止nginx服务器

![image-20250828193551605](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250828193551605.png)

===注意：Nginx 默认占用 80端口号，如果 80端口号被占用，可以在nginx.conf中修改端口号。

```
netstat -ano | findStr 80
```

===小结

![image-20250828193849123](D:\软件工程\JavaWeb + AI\05-前端Web实战\assets\image-20250828193849123.png)