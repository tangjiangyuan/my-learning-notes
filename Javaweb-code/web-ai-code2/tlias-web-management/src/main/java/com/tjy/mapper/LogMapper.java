package com.tjy.mapper;

import com.tjy.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    /**
     * 分页查询所有日志信息
     */
    @Select("select ol.*, e.name operateEmpName from operate_log ol left join emp e on ol.operate_emp_id = e.id")
    List<OperateLog> list();
}
