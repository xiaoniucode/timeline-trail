package com.xiaoniucode.timeline.trail.service.impl;

import com.xiaoniucode.timeline.trail.controller.admin.req.UpdateSocialReq;
import com.xiaoniucode.timeline.trail.entity.Social;
import com.xiaoniucode.timeline.trail.repository.SocialRepository;
import com.xiaoniucode.timeline.trail.service.SocialService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuxin
 */
@Service
public class SocialServiceImpl implements SocialService {

    @Autowired
    private SocialRepository socialRepository;

    private static final Integer DEFAULT_SOCIAL_ID = 1;

    @Override
    public Social getSocial() {
        // 不存在就创建新的
        return socialRepository.findById(DEFAULT_SOCIAL_ID)
                .orElseGet(() -> {
                    Social social = new Social();
                    social.setId(DEFAULT_SOCIAL_ID);
                    return socialRepository.save(social);
                });
    }

    @Override
    public void update(UpdateSocialReq req) {
        // 不存在就创建新的
        Social social = socialRepository.findById(DEFAULT_SOCIAL_ID)
                .orElse(new Social());

        // 设置ID为1
        social.setId(DEFAULT_SOCIAL_ID);

        // 复制属性
        BeanUtils.copyProperties(req, social, "id");

        // 保存
        socialRepository.save(social);
    }
}
