package com.xiaoniucode.timeline.trail.controller.admin;

import com.xiaoniucode.timeline.trail.config.Ajax;
import com.xiaoniucode.timeline.trail.controller.admin.req.LoginReq;
import com.xiaoniucode.timeline.trail.entity.LoginUser;
import com.xiaoniucode.timeline.trail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liuxin
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("do-login")
    @ResponseBody
    public Ajax login(HttpSession session,@RequestBody @Validated LoginReq loginReq) {
        LoginUser login = userService.login(session, loginReq);
        return Ajax.success(login);
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        userService.logout(session);
        return "/admin/login";
    }
}
