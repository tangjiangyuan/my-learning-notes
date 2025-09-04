import request from "@/utils/request";

// 查询学员列表数据
export const queryPageApi = (name, degree, clazzId, page, pageSize) => 
  request.get(`/students?name=${name}&degree=${degree}&clazzId=${clazzId}&page=${page}&pageSize=${pageSize}`);

// 新增
export const addApi = (student) => request.post('/students', student);

// 根据id查询学员信息 -- 路径参数通过字符模板拼接路径
export const queryInfoApi = (id) => request.get(`/students/${id}`);

// 修改
export const updateApi = (student) => request.put('/students', student);

// 违纪处理
export const updateViolationApi = (id, socre) => request.put(`/students/violation/${id}/${socre}`);

// 删除
export const deleteApi = (ids) => request.delete(`/students/${ids}`);

