package com.xiaoniucode.timeline.trail.util;


import com.xiaoniucode.timeline.trail.entity.LoginUser;

import javax.servlet.http.HttpSession;

/**
 * @author liuxin
 */
public abstract class SecurityUtils {

    // 存储当前线程的用户信息
    private static final ThreadLocal<LoginUser> CURRENT_USER = new ThreadLocal<>();

    // 设置当前用户信息
    public static void setUser(LoginUser user) {
        CURRENT_USER.set(user);
    }

    // 获取当前用户信息
    public static LoginUser getUser() {
        return CURRENT_USER.get();
    }

    // 获取当前用户信息
    public static Integer getUserId() {
        if (!isLogin()) {
            return null;
        }
        return CURRENT_USER.get().getUserId();
    }

    // 检查是否已登录
    public static boolean isLogin() {
        return CURRENT_USER.get() != null;
    }

    // 获取当前用户用户名
    public static String getUsername() {
        LoginUser user = CURRENT_USER.get();
        return user != null ? user.getUsername() : null;
    }

    // 清除当前线程用户信息
    public static void clear() {
        CURRENT_USER.remove();
    }

    public static void logout(HttpSession session) {
        session.invalidate();
        clear();
    }
}
