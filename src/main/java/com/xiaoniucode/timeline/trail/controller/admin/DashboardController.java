package com.xiaoniucode.timeline.trail.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制面板
 * @author liuxin
 */
@RequestMapping({"/admin/dashboard","/admin"})
@Controller
public class DashboardController {

    @GetMapping
    private String index(){
        return "admin/dashboard";
    }
}
