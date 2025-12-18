package com.xiaoniucode.timeline.trail.service;


import com.xiaoniucode.timeline.trail.controller.admin.req.LoginReq;
import com.xiaoniucode.timeline.trail.controller.admin.req.UpdateUserReq;
import com.xiaoniucode.timeline.trail.entity.LoginUser;
import com.xiaoniucode.timeline.trail.entity.User;

import javax.servlet.http.HttpSession;


/**
 * @author liuxin
 */
public interface UserService {
    User findByUsername(String username);

      void updateUser(Integer userId, UpdateUserReq req, HttpSession session);

    User getById(Integer userId);

    void logout(HttpSession session);

    LoginUser login(HttpSession session,LoginReq loginReq);

}
