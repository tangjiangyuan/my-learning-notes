package com.tjy;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/31 14:35
 */
@RestController
public class RequestController {

    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        // 1. 获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式:" + method);
        // 2. 获取请求url路径
        String uri = request.getRequestURI(); // 获取资源访问路径 /request
        System.out.println("请求uri路径:" + uri);
        String url = request.getRequestURL().toString(); // 获取完整资源路径
        System.out.println("请求url路径:" + url);
        // 3. 获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议:" + protocol);
        // 4. 获取请求参数 - name
        String name = request.getParameter("name");
        System.out.println("请求参数:" + name);
        // 5. 获取请求头 - Accept
        String requestHeader = request.getHeader("Accept");
        System.out.println("请求头:" + requestHeader);
        return "OK";
    }

}
