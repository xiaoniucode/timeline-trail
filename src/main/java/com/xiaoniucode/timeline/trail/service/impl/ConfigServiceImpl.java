package com.xiaoniucode.timeline.trail.service.impl;

import com.xiaoniucode.timeline.trail.controller.admin.req.UpdateConfigReq;
import com.xiaoniucode.timeline.trail.entity.Config;
import com.xiaoniucode.timeline.trail.repository.ConfigRepository;
import com.xiaoniucode.timeline.trail.service.ConfigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuxin
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigRepository configRepository;

    private static final Integer DEFAULT_CONFIG_ID = 1;

    @Override
    public Config getConfig() {
        return configRepository.findById(DEFAULT_CONFIG_ID)
                .orElseGet(() -> {
                    Config config = new Config();
                    config.setId(DEFAULT_CONFIG_ID);
                    return configRepository.save(config);
                });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UpdateConfigReq updateConfigReq) {
        // 不存在就创建新的
        Config config = configRepository.findById(DEFAULT_CONFIG_ID)
                .orElse(new Config());

        // 设置ID为1
        config.setId(DEFAULT_CONFIG_ID);

        // 复制属性
        BeanUtils.copyProperties(updateConfigReq, config, "id");

        // 保存
        configRepository.save(config);
    }
}
