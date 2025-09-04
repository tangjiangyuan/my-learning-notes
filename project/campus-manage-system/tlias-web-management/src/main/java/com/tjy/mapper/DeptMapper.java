package com.tjy.mapper;

import com.tjy.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DeptMapper {

    /* 查询所有部门信息 */
    /*
    方式一：
    @Results({
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })*/
    // 方式二：@Select("select id, name, create_time createTime, update_time updateTime from dept order by update_time desc;")
    @Select("select id, name, create_time, update_time from dept order by update_time desc;")
    List<Dept> findAll();


    /* 根据id删除部门 */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    // 如果传入的参数是对象，则SQL语句中直接写对象的属性名，同时补全的信息也需要加入SQL语句中，否则补全的信息会被忽略
    @Insert("insert into dept(name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime});")
    void addByName(Dept dept);

    /* 根据id查询部门 */
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getInfoById(Integer id);

    /* 修改部门信息 */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
