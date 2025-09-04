import request from "@/utils/request";

/* const queryAllApi = () => {
  return request.get('/depts');
} */

// 查询全部部门数据
export const queryAllApi = () => request.get('/depts');

// 新增
export const addApi = (dept) => request.post('/depts', dept);

// 根据id查询部门信息 -- 路径参数通过字符模板拼接路径
export const queryByIdApi = (id) => request.get(`/depts/${id}`);

// 修改
export const updateApi = (dept) => request.put('/depts', dept);

// 删除
export const deleteByIdApi = (id) => request.delete(`/depts?id=${id}`);
