import request from "@/utils/request";

// 查询班级列表数据
export const queryPageApi = (name, begin, end, page, pageSize) => 
  request.get(`/clazzs?name=${name}&begin=${begin}&end=${end}&page=${page}&pageSize=${pageSize}`)

// 新增
export const addApi = (clazz) => request.post('/clazzs', clazz);

// 根据id查询班级信息 -- 路径参数通过字符模板拼接路径
export const queryInfoApi = (id) => request.get(`/clazzs/${id}`);

// 修改
export const updateApi = (clazz) => request.put('/clazzs', clazz);

// 删除
export const deleteApi = (ids) => request.delete(`/clazzs/${ids}`);

// 查询所有班级
export const queryAllApi = () => request.get('/clazzs/list');
