package com.xiaoniucode.timeline.trail.controller.admin;

import com.xiaoniucode.timeline.trail.config.Ajax;
import com.xiaoniucode.timeline.trail.controller.admin.req.UpdateSocialReq;
import com.xiaoniucode.timeline.trail.entity.Social;
import com.xiaoniucode.timeline.trail.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 社交信息
 *
 * @author liuxin
 */
@RequestMapping("/admin/social")
@Controller
public class SocialController {

    @Autowired
    private SocialService socialService;

    @GetMapping("index")
    private String index(Model model) {
        Social social = socialService.getSocial();
        model.addAttribute("social", social);
        return "admin/social";
    }

    @PutMapping("update")
    @ResponseBody
    public Ajax update(@RequestBody @Validated UpdateSocialReq req) {
        socialService.update(req);
        return Ajax.success();
    }
}
