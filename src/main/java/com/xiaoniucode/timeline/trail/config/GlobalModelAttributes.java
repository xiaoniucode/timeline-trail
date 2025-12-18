package com.xiaoniucode.timeline.trail.config;

import com.xiaoniucode.timeline.trail.entity.LoginUser;
import com.xiaoniucode.timeline.trail.util.SecurityUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuxin
 */
@ControllerAdvice
public class GlobalModelAttributes {

    @ModelAttribute
    public void addGlobalAttributes(Model model, HttpServletRequest request) {
        LoginUser user = SecurityUtils.getUser();
        if (user != null) {
            model.addAttribute("loginUser", user);
        }
    }
}
