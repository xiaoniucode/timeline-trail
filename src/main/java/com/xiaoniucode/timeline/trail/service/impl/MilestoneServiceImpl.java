package com.xiaoniucode.timeline.trail.service.impl;

import com.xiaoniucode.timeline.trail.config.BizException;
import com.xiaoniucode.timeline.trail.controller.admin.req.UpdateMilestoneReq;
import com.xiaoniucode.timeline.trail.entity.LanguageEnum;
import com.xiaoniucode.timeline.trail.entity.Milestone;

import com.xiaoniucode.timeline.trail.repository.MilestoneRepository;
import com.xiaoniucode.timeline.trail.service.MilestoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


/**
 * @author liuxin
 */
@Slf4j
@Service
public class MilestoneServiceImpl implements MilestoneService {

    @Autowired
    private MilestoneRepository milestoneRepository;

    private static final Integer DEFAULT_MILESTONE_ID = 1;

    @Override
    public String getMilestoneByLang(String lang) {
        // 参数校验
        validateLang(lang);

        // 获取里程碑数据
        Milestone milestone = getOrCreateMilestone();

        // 根据语言返回对应的JSON数据
        LanguageEnum languageEnum = LanguageEnum.getByCode(lang);
        return getJsonByLanguage(milestone, languageEnum);
    }

    @Override
    public Milestone getMilestone() {
        return getOrCreateMilestone();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMilestone(UpdateMilestoneReq req) {
        // 参数校验
        if (req == null) {
            throw new BizException("请求参数不能为空");
        }

        // 分别验证中英文JSON数据
        if (StringUtils.hasText(req.getZh())) {
            validateJsonData(req.getZh(), "中文");
        }
        if (StringUtils.hasText(req.getEn())) {
            validateJsonData(req.getEn(), "英文");
        }

        // 获取里程碑数据
        Milestone milestone = getOrCreateMilestone();

        // 更新两种语言的JSON数据
        // 中文
        if (StringUtils.hasText(req.getZh())) {
            milestone.setZh(req.getZh().trim());
            log.info("更新中文里程碑数据，数据长度: {}", req.getZh().length());
        }

        // 英文
        if (StringUtils.hasText(req.getEn())) {
            milestone.setEn(req.getEn().trim());
            log.info("更新英文里程碑数据，数据长度: {}", req.getEn().length());
        }

        // 保存
        milestoneRepository.save(milestone);
        log.info("更新里程碑数据成功，ID: {}", DEFAULT_MILESTONE_ID);
    }

    /**
     * 获取或创建里程碑数据
     */
    private Milestone getOrCreateMilestone() {
        return milestoneRepository.findById(DEFAULT_MILESTONE_ID)
                .orElseGet(() -> {
                    Milestone newMilestone = new Milestone();
                    newMilestone.setId(DEFAULT_MILESTONE_ID);
                    newMilestone.setZh("[]");
                    newMilestone.setEn("[]");
                    log.info("创建新的里程碑数据，ID: {}", DEFAULT_MILESTONE_ID);
                    return milestoneRepository.save(newMilestone);
                });
    }

    /**
     * 根据语言获取JSON数据
     */
    private String getJsonByLanguage(Milestone milestone, LanguageEnum language) {
        switch (language) {
            case ZH:
                return StringUtils.hasText(milestone.getZh()) ? milestone.getZh() : "[]";
            case EN:
                return StringUtils.hasText(milestone.getEn()) ? milestone.getEn() : "[]";
            default:
                return "[]";
        }
    }

    /**
     * 验证语言参数
     */
    private void validateLang(String lang) {
        if (!StringUtils.hasText(lang)) {
            throw new BizException("语言参数不能为空");
        }

        if (!LanguageEnum.isValid(lang)) {
            throw new BizException("不支持的语言类型: " + lang + "，支持的语言: " +
                    String.join(", ", LanguageEnum.getAllCodes()));
        }
    }

    /**
     * 验证JSON数据
     */
    private void validateJsonData(String jsonData, String fieldName) {
        if (jsonData == null) {
            throw new BizException(fieldName + "JSON数据不能为空");
        }

        // 简单的JSON格式验证
        if (!isValidJson(jsonData)) {
            throw new BizException(fieldName + "数据格式无效，必须是有效的JSON数组或对象");
        }
    }

    /**
     * 简单验证JSON格式
     */
    private boolean isValidJson(String jsonData) {
        try {
            if (jsonData == null) {
                return false;
            }
            String trimmed = jsonData.trim();
            if (trimmed.startsWith("[") && trimmed.endsWith("]")) {
                return true;
            } else {
                return trimmed.startsWith("{") && trimmed.endsWith("}");
            }
        } catch (Exception e) {
            log.warn("JSON格式验证失败: {}", e.getMessage());
            return false;
        }
    }
}
