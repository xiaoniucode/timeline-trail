package com.xiaoniucode.timeline.trail.controller.admin;

import com.xiaoniucode.timeline.trail.config.Ajax;
import com.xiaoniucode.timeline.trail.controller.admin.req.UpdateConfigReq;
import com.xiaoniucode.timeline.trail.entity.Config;
import com.xiaoniucode.timeline.trail.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 网站配置
 *
 * @author liuxin
 */
@Controller
@RequestMapping("/admin/config")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @GetMapping
    public String index(Model model) {
        Config config = configService.getConfig();
        model.addAttribute("config", config);
        return "admin/config";
    }

    @ResponseBody
    @PutMapping("update")
    public Ajax update(@RequestBody @Validated UpdateConfigReq updateConfigReq) {
        configService.update(updateConfigReq);
        return Ajax.success();
    }

    @ResponseBody
    @GetMapping("get-config")
    public Ajax getConfig() {
        Config config = configService.getConfig();
        return Ajax.success(config);
    }
}
