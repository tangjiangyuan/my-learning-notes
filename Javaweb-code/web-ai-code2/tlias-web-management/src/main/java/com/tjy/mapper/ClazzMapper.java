package com.tjy.mapper;

import com.tjy.pojo.Clazz;
import com.tjy.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClazzMapper {

    /*----------原始分页查询----------------*/
    /* 查询总记录数 */
    /*@Select("select count(*) from clazz c left join emp e on c.master_id = e.id")
    Long count();

    @Select("select c.*, e.name masterName from clazz c left join emp e on c.master_id = e.id limit #{start}, #{pageSize}")
    List<Clazz> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);*/

    /**
     * 分页查询--PageHelper
     */
    List<Clazz> list(ClazzQueryParam cqp);


    /**
     * 添加班级
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Clazz clazz);

    /**
     * 根据 ID查询
     */
    @Select("select * from clazz where id = #{id}")
    Clazz getById(Integer id);

    /**
     * 修改班级
     */
    void updateById(Clazz clazz);

    /**
     * 删除班级
     */
    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

    /**
     * 查询所有班级
     */
    @Select("select c.*, e.name masterName from clazz c left join emp e on c.master_id = e.id")
    List<Clazz> getAllInfos();
}
