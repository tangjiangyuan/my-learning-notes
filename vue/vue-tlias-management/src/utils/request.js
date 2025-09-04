import axios from 'axios'
import { ElMessage } from 'element-plus';
import router from '../router'

//创建axios实例对象
const request = axios.create({
  baseURL: '/api',
  timeout: 600000
})

//axios的请求 request 拦截器 - 获取localStorage中的token，在请求头中添加token
request.interceptors.request.use(
  (config) => { //成功回调
    const userLogin = JSON.parse(localStorage.getItem('userLogin'));
    if (userLogin && userLogin.token) {
      config.headers.token = userLogin.token;
    }
    return config
  },
  (error) => { //失败回调
    return Promise.reject(error)
  }
)


//axios的响应 response 拦截器
request.interceptors.response.use(
  (response) => { //成功回调
    return response.data
  },
  (error) => { //失败回调
    // === : 全等(比较类型和内容)，先比较类型再比较值
    // == : 具备隐式类型转换 '401' == 401 true, 
    if (error.response.status === 401) { 
      // 1. 提示信息
      ElMessage.error("登录超时，请重新登录！");
      // 2. 页面跳转
      router.push('/login');
    } else {
      ElMessage.error('接口访问异常！');
    }
    return Promise.reject(error)
  }
)

export default request