package com.tjy.filter;

import com.tjy.util.CurrentHolder;
import com.tjy.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @version 1.0
 * @date 2025/8/14 10:13
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 前提: 进行强转
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 1. 获取请求路径
        String requestURI = request.getRequestURI(); // 不包含前面的 http://localhost:8080

        // 2. 判断是否是登录请求，如果路径中包含 /login, 说明是登录操作，放行
        if (requestURI.contains("/login")) {
            log.info("登录请求, 放行");
            filterChain.doFilter(request, response);
            return; // 确保在放行后不会继续执行后续代码
        }

        // 3. 获取请求头中的令牌(token)
        String token = request.getHeader("token");

        // 4. 判断token是否存在，如果不存在，说明用户未登录，返回错误信息(响应401状态码)
        if (token == null || token.isEmpty()) {
            log.info("令牌为空，响应401状态码");
            response.setStatus(401);
            return;
        }

        // 5. 如果token存在，校验令牌，如果校验失败，返回错误信息(响应401状态码)
        try {
            Claims claims = JwtUtils.parseJWT(token);
            // 获取员工 ID
            Integer empId = Integer.valueOf(claims.get("id").toString());
            // 存入 ThreadLocal 中
            CurrentHolder.setCurrentID(empId);
            log.info("登录员工的ID: {}, 已存入ThreadLocal。", empId);
        } catch (Exception e) {
            log.info("令牌非法，响应401状态码");
            response.setStatus(401);
            return;
        }

        // 6. 校验通过，放行
        log.info("令牌合法，放行");
        filterChain.doFilter(request, response);

        // 7. 移除 ThreadLocal 中的数据，避免内存泄漏
        CurrentHolder.remove();
    }
}
