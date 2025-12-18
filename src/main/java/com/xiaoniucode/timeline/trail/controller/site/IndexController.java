package com.xiaoniucode.timeline.trail.controller.site;

import com.google.gson.Gson;
import com.xiaoniucode.timeline.trail.entity.Config;
import com.xiaoniucode.timeline.trail.entity.Social;
import com.xiaoniucode.timeline.trail.service.ConfigService;
import com.xiaoniucode.timeline.trail.service.MilestoneService;
import com.xiaoniucode.timeline.trail.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author liuxin
 */
@RequestMapping()
@Controller
public class IndexController {
    @Autowired
    private ConfigService configService;
    @Autowired
    private SocialService socialService;

    @Autowired
    private MilestoneService milestoneService;

    @GetMapping({"/", "index"})
    public String index(Model model, @RequestParam(value = "lang", defaultValue = "zh") String lang) {
        Config config = configService.getConfig();
        Social social = socialService.getSocial();
        model.addAttribute("config", config);
        model.addAttribute("social", social);
        String data = milestoneService.getMilestoneByLang(lang);
        List milestones = new Gson().fromJson(data, List.class);
        model.addAttribute("milestones", milestones);
        return "index";
    }
}
