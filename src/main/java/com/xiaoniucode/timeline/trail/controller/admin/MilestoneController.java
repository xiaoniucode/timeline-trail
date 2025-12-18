package com.xiaoniucode.timeline.trail.controller.admin;

import com.xiaoniucode.timeline.trail.config.Ajax;
import com.xiaoniucode.timeline.trail.controller.admin.req.UpdateMilestoneReq;
import com.xiaoniucode.timeline.trail.entity.Milestone;
import com.xiaoniucode.timeline.trail.service.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuxin
 */
@RequestMapping("/admin/milestone")
@Controller
public class MilestoneController {
    @Autowired
    private MilestoneService milestoneService;

    @GetMapping
    private String index() {
        return "admin/milestone";
    }

    @ResponseBody
    @PutMapping("update")
    public Ajax updateMilestone(@RequestBody @Validated UpdateMilestoneReq milestone) {
     milestoneService.updateMilestone(milestone);
        return Ajax.success();
    }

    @GetMapping("get")
    @ResponseBody
    public Ajax getMilestone() {
        Milestone milestone = milestoneService.getMilestone();
        return Ajax.success(milestone);
    }
}
