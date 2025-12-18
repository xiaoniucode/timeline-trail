package com.xiaoniucode.timeline.trail.controller.admin.req;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
/**
 * @author liuxin
 */
@Setter
@Getter
@ToString
public class UpdateConfigReq implements Serializable {
    private Integer id;
    private String title;
    private String background;
    private String avatar;
    private String copyright;
    private String author;
    private String favicon;
    private String keywords;
    private String description;
    private String robots;
}
