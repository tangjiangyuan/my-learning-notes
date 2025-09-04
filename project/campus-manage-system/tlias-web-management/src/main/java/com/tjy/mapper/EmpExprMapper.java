package com.tjy.mapper;

import com.tjy.pojo.EmpExpr;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 员工经历
 */
@Mapper
public interface EmpExprMapper {

    /**
     * 新增员工工作经历
     */
    void insertBatch(@Param("exprList") List<EmpExpr> exprList);

    /**
     * 根据id批量删除员工工作经历信息
     */
    void deleteByEmpIds(@Param("empIds") List<Integer> empIds);
}
