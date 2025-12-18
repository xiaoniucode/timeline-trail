package com.xiaoniucode.timeline.trail.controller.admin.req;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
/**
 * @author liuxin
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class UpdateMilestoneReq implements Serializable {
    @NotBlank(message = "数据不能为空")
    private String zh;
    @NotBlank(message = "数据不能为空")
    private String en;
}
