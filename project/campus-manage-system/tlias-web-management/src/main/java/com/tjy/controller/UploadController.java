package com.tjy.controller;

import com.tjy.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @version 1.0
 * @date 2025/8/10 11:11
 */
@Slf4j
@SuppressWarnings("ALL")
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
        // 说明：方法形参要与前端请求的参数名一致，否则使用 @RequestParam注解指定参数名
        log.info("上传文件：{}，{}，{}", name, age, file);
        // 1. 获取原始文件名
        String originalFilename = file.getOriginalFilename();

        // 2. 新文件名
        // 获取扩展名; originalFilename.lastIndexOf 获取最后一个点的索引
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 使用UUID进行拼接
        String newFileName = UUID.randomUUID().toString() + extension;

        // 3. 保存文件
        file.transferTo(new File("D:/images", newFileName));
        return Result.success();
    }
}
