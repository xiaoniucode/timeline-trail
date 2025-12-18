package com.xiaoniucode.timeline.trail.controller.admin;

import com.xiaoniucode.timeline.trail.config.Ajax;
import com.xiaoniucode.timeline.trail.controller.admin.req.UpdateUserReq;
import com.xiaoniucode.timeline.trail.entity.User;
import com.xiaoniucode.timeline.trail.service.UserService;
import com.xiaoniucode.timeline.trail.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 用户管理
 * @author liuxin
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("profile")
    public String profile(Model model) {
       Integer userId = SecurityUtils.getUserId();
        User user = userService.getById(userId);
        model.addAttribute("user", user);
        return "admin/profile";
    }

    @GetMapping("password")
    public String password() {
        return "admin/profile";
    }

    @ResponseBody
    @PutMapping("update-user")
    public Ajax updateUser(@RequestBody @Validated UpdateUserReq req, HttpSession session) {
        Integer userId = SecurityUtils.getUserId();
        userService.updateUser(userId, req, session);
        return Ajax.success();
    }
}
