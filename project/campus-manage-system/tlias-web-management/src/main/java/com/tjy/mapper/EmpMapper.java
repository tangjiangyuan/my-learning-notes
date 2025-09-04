package com.tjy.mapper;

import com.tjy.pojo.Emp;
import com.tjy.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {


    /*------------------------------ 原始分页查询 --------------------------------*/
     /*获取总记录数 */
    /*@Select("select count(*) from emp e left join dept d on e.dept_id = d.id;")
    Long count();*/

     /*分页查询 */
    // 说明=== Emp中封装的部门名称变量名为deptName，所以此处需要起别名
    /*@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
            "order by e.update_time desc " +
            "limit #{start}, #{pageSize}")
    List<Emp> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);*/

    // List<Emp> list(@Param("name") String name, @Param("gender") Integer gender, @Param("begin") LocalDate begin, @Param("end") LocalDate end);

    /**
     * 分页查询
     */
    List<Emp> list(EmpQueryParam eqp);

    /**
     * 添加员工基本信息
     */
    @Options(useGeneratedKeys = true, keyProperty = "id") // 获取到生成的主键 -- 主键返回
    void insert(Emp emp);

    /**
     * 根据id批量删除员工基本信息
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据id查询员工的基本信息以及工作经历信息
     */
    Emp getInfo(Integer id);

    /**
     * 根据id修改员工的基本信息
     */
    void updateById(Emp emp);

    /**
     * 获取员工职位信息
     */
    @MapKey("position")
    List<Map<String, Object>> countJobData();

    /**
     * 统计员工性别信息
     */
    @MapKey("name")
    List<Map<String, Object>> countGenderData();

    /**
     * 查询全部员工
     */
    List<Emp> getEmpList();

    /**
     * 登录
     */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp selectByUsernameAndPassword(Emp emp);
}

