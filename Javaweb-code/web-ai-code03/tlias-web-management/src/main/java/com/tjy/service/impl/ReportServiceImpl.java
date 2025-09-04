package com.tjy.service.impl;

import com.tjy.mapper.EmpMapper;
import com.tjy.mapper.StudentMapper;
import com.tjy.pojo.JobOption;
import com.tjy.pojo.StuNumberOption;
import com.tjy.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @date 2025/8/12 9:17
 */
@Service
@SuppressWarnings("ALL")
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 统计员工职位信息
     */
    @Override
    public JobOption getEmpJobData() {
        // 1. 获取返回的数据
        List<Map<String, Object>> list = empMapper.countJobData();
        // 2. 将数据进行组装并返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("position")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("count")).toList();
        return new JobOption(jobList, dataList);
    }

    /**
     * 统计员工性别信息
     */
    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        List<Map<String, Object>> genderList = empMapper.countGenderData();
        return genderList;
    }

    /**
     * 统计学生学历信息
     */
    @Override
    public List<Map<String, Object>> getStudentDegree() {
        List<Map<String, Object>> degreeList = studentMapper.countStudentDegree();
        return degreeList;
    }

    /**
     * 统计各个班级的学员数量
     */
    @Override
    public StuNumberOption getStudentNumber() {
        List<Map<String, Object>> list = studentMapper.getStuNumber();
        List<Object> clazzList = list.stream().map(msgList -> msgList.get("clazzName")).toList();
        List<Object> dataList = list.stream().map(msgList -> msgList.get("stuCount")).toList();
        return new StuNumberOption(clazzList, dataList);
    }
}
