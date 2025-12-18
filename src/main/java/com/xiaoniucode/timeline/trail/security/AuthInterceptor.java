package com.xiaoniucode.timeline.trail.security;


import com.xiaoniucode.timeline.trail.entity.LoginUser;
import com.xiaoniucode.timeline.trail.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author liuxin
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        LoginUser user = (LoginUser) session.getAttribute("loginUser");
        if (user != null) {
            SecurityUtils.setUser(user);
        }
        // 非管理员请求直接通过
        if (!request.getRequestURI().startsWith("/admin/")) {
            return true;
        }
        // 管理员请求需要登录
        if (user == null) {
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清理 ThreadLocal，防止内存泄漏
        SecurityUtils.clear();
    }
}
