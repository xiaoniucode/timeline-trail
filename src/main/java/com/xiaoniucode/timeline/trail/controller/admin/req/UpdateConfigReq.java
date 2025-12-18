package com.xiaoniucode.timeline.trail.controller.admin.req;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author liuxin
 */
@Setter
@Getter
@ToString
public class UpdateConfigReq implements Serializable {
    private String title;
    private String background;
    private String avatar;
    private String copyright;
    @Size(max = 20, message = "内容过长")
    private String author;
    private String favicon;
    private String keywords;
    private String description;
    private String robots;
}
