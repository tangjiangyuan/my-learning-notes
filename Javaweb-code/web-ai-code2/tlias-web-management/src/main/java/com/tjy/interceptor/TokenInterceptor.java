package com.tjy.interceptor;

import com.tjy.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @version 1.0
 * @date 2025/8/14 14:29
 * msg: 定义令牌校验拦截器
 */
@Slf4j
@SuppressWarnings("all")
//@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*// 1. 获取资源访问路径
        String requestURI = request.getRequestURI();

        // 2. 判断是否包含 /login true -> 放行; false -> 拦截
        if (requestURI.contains("/login")) {
            log.info("放行");
            return true;
        }*/

        // 3. 获取JWT令牌
        String token = request.getHeader("token");

        // 4. 判断令牌是否存在，如果存在，则通过，否则拦截
        if (token == null || token.isEmpty()) {
            log.info("令牌为空，响应401");
            response.setStatus(401);
            return false;
        }

        // 5. 解析令牌，如果解析成功，则通过，否则拦截
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("用户未登录，请先登录");
            response.setStatus(401);
            return false;
        }

        // 6. 放行
        log.info("令牌合法，放行");
        return true;
    }
}
