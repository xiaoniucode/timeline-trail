package com.xiaoniucode.timeline.trail.service.impl;

import com.xiaoniucode.timeline.trail.config.BizException;
import com.xiaoniucode.timeline.trail.controller.admin.req.LoginReq;
import com.xiaoniucode.timeline.trail.controller.admin.req.UpdateUserReq;
import com.xiaoniucode.timeline.trail.entity.LoginUser;
import com.xiaoniucode.timeline.trail.entity.User;
import com.xiaoniucode.timeline.trail.repository.UserRepository;
import com.xiaoniucode.timeline.trail.service.UserService;
import com.xiaoniucode.timeline.trail.util.PasswordUtil;
import com.xiaoniucode.timeline.trail.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpSession;

/**
 * @author liuxin
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUser(@Validated Integer userId, UpdateUserReq req, HttpSession session) {
        User user = userRepository.getById(userId);

        if (!PasswordUtil.matches(req.getOldPassword(), user.getPassword())) {
            throw new BizException("旧密码不正确！");
        }
        user.setUsername(req.getUsername());
        user.setPassword(PasswordUtil.encode(req.getNewPassword()));
        userRepository.save(user);
        SecurityUtils.logout(session);
    }


    @Override
    public User getById(Integer userId) {
        return userRepository.getById(userId);
    }

    @Override
    public void logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        // 清除线程本地存储的安全信息
        SecurityUtils.clear();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public LoginUser login(HttpSession session, LoginReq loginReq) {
        // 1. 验证用户是否存在
        User user = userRepository.findByUsername(loginReq.getUsername());
        if (user == null) {
            throw new BizException("用户名或密码错误");
        }
        // 2. 验证密码
        if (!PasswordUtil.matches(loginReq.getPassword(), user.getPassword())) {
            throw new BizException("用户名或密码错误");
        }
        LoginUser loginUser = new LoginUser(user.getId(), user.getUsername());
        session.setAttribute("loginUser", loginUser);
        SecurityUtils.setUser(loginUser);
        return loginUser;
    }
}
