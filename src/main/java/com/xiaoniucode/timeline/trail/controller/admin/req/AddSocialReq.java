package com.xiaoniucode.timeline.trail.controller.admin.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author liuxin
 */
@Setter
@Getter
@ToString
public class AddSocialReq {
    private String email;
    private String weibo;
    private String github;
    private String gitee;
    private String twitter;
    private String presume;
    private String site;
}
