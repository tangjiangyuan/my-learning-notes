package com.tjy.controller;

import com.tjy.pojo.JobOption;
import com.tjy.pojo.Result;
import com.tjy.pojo.StuNumberOption;
import com.tjy.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @date 2025/8/12 9:16
 */
@Slf4j
@SuppressWarnings("ALL")
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计各个职位的员工人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("统计各个职位的员工人数");
        JobOption jobOption =  reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计员工性别信息
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("统计员工性别信息");
        List<Map<String, Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /**
     * 统计学生学历信息
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegree() {
        log.info("统计学生学历信息");
        List<Map<String, Object>> degreeList = reportService.getStudentDegree();
        return Result.success(degreeList);
    }

    /**
     * 统计各个班级的学员数量
     */
    @GetMapping("/studentCountData")
    public Result getStudentNumber() {
        log.info("统计各个班级的学员数量");
        StuNumberOption sno = reportService.getStudentNumber();
        return Result.success(sno);
    }
}
