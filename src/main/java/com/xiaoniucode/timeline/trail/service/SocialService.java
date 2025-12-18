package com.xiaoniucode.timeline.trail.service;

import com.xiaoniucode.timeline.trail.controller.admin.req.UpdateSocialReq;
import com.xiaoniucode.timeline.trail.entity.Social;

/**
 * @author liuxin
 */
public interface SocialService {
    Social getSocial();
    void update(UpdateSocialReq req);
}
