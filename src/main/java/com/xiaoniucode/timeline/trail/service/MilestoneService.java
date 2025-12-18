package com.xiaoniucode.timeline.trail.service;

import com.xiaoniucode.timeline.trail.controller.admin.req.UpdateMilestoneReq;
import com.xiaoniucode.timeline.trail.entity.Milestone;

/**
 * @author liuxin
 */
public interface MilestoneService {
    String getMilestoneByLang(String lang);
    Milestone getMilestone();
    void updateMilestone(UpdateMilestoneReq  milestone);
}
