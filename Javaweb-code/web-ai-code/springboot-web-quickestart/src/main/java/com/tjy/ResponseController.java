package com.tjy;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/31 15:15
 */
@SuppressWarnings("ALL")
@RestController
public class ResponseController {

    /**
     * 方式一: HttpServletResponse 设置响应数据
     */
    @RequestMapping("/response")
    public void response(HttpServletResponse  response) throws IOException {
        // 1. 设置响应状态码
        response.setStatus(401);
        // 2. 设置响应头
        response.setHeader("name", "tjy");
        // 3. 设置响应体
        response.getWriter().write("<h1>hello Response</h1>");
    }

    /**
     * 方式二: ResponseEntity 设置响应数据
     */
    @RequestMapping("/response2")
    public ResponseEntity<String> responseEntity() {
        return ResponseEntity
                .status(401) // 响应状态码
                .header("name", "tom") // 响应头
                .body("<h1>hello ResponseEntity</h1>"); // 响应体
    }

}
