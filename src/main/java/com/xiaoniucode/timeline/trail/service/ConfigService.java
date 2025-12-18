package com.xiaoniucode.timeline.trail.service;

import com.xiaoniucode.timeline.trail.controller.admin.req.UpdateConfigReq;
import com.xiaoniucode.timeline.trail.entity.Config;

public interface ConfigService {
    Config getConfig();

    void update(UpdateConfigReq updateConfigReq);
}
