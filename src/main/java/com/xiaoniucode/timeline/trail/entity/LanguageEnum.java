package com.xiaoniucode.timeline.trail.entity;

import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 语言枚举
 */
@Getter
public enum LanguageEnum {

    ZH("zh", "中文", "Chinese"),
    EN("en", "英文", "English"),
    ;

    /**
     * 语言代码
     */
    private final String code;

    /**
     * 中文名称
     */
    private final String zhName;

    /**
     * 英文名称
     */
    private final String enName;

    LanguageEnum(String code, String zhName, String enName) {
        this.code = code;
        this.zhName = zhName;
        this.enName = enName;
    }

    /**
     * 根据code获取枚举
     */
    public static LanguageEnum getByCode(String code) {
        if (code == null) {
            return ZH;
        }

        for (LanguageEnum language : values()) {
            if (language.getCode().equalsIgnoreCase(code)) {
                return language;
            }
        }

        return ZH;
    }

    /**
     * 检查code是否有效
     */
    public static boolean isValid(String code) {
        if (code == null) {
            return false;
        }

        for (LanguageEnum language : values()) {
            if (language.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 获取所有支持的语言代码
     */
    public static List<String> getAllCodes() {
        return Arrays.stream(values())
                .map(LanguageEnum::getCode)
                .collect(Collectors.toList());
    }

    /**
     * 获取所有支持的语言显示名称（中文）
     */
    public static Map<String, String> getAllLanguagesZh() {
        Map<String, String> map = new LinkedHashMap<>();
        for (LanguageEnum language : values()) {
            map.put(language.getCode(), language.getZhName());
        }
        return map;
    }

    /**
     * 获取所有支持的语言显示名称（英文）
     */
    public static Map<String, String> getAllLanguagesEn() {
        Map<String, String> map = new LinkedHashMap<>();
        for (LanguageEnum language : values()) {
            map.put(language.getCode(), language.getEnName());
        }
        return map;
    }

    /**
     * 判断是否为中文
     */
    public boolean isZh() {
        return this == ZH;
    }

    /**
     * 判断是否为英文
     */
    public boolean isEn() {
        return this == EN;
    }

    @Override
    public String toString() {
        return code;
    }
}
