package com.tjy.service;

import com.tjy.pojo.JobOption;
import com.tjy.pojo.StuNumberOption;

import java.util.List;
import java.util.Map;

public interface ReportService {

    /**
     * 统计各个职位的员工人数
     */
    JobOption getEmpJobData();

    /**
     * 统计员工性别信息
     */
    List<Map<String, Object>> getEmpGenderData();

    /**
     * 统计各个学历的学员数量
     */
    List<Map<String, Object>> getStudentDegree();

    /**
     * 统计各个班级的学员数量
     */
    StuNumberOption getStudentNumber();
}
