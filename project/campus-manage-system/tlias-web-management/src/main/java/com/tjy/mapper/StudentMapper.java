package com.tjy.mapper;

import com.tjy.pojo.Student;
import com.tjy.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    /**
     * 分页查询学员信息
     */
    List<Student> page(StudentQueryParam sqp);

    /**
     * 添加学员
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Student student);

    /**
     * 根据ID查询学员
     */
    Student getById(Integer id);

    /**
     * 修改学员信息
     */
    void update(Student student);

    /**
     * 根据ID删除学员
     */
    void deleteById(@Param("ids") List<Integer> ids);

    /**
     * 通过id修改学员的违纪分数
     */
    void handleViolation(@Param("id") Integer id, @Param("count") Short count, @Param("score") Short score);

    /**
     * 统计学员学历信息
     */
    @MapKey("name")
    List<Map<String, Object>> countStudentDegree();

    /**
     * 统计各个班级的学员数量
     */
    @MapKey("clazzName")
    List<Map<String, Object>> getStuNumber();
}
