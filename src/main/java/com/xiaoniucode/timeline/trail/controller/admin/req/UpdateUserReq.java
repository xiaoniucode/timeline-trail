package com.xiaoniucode.timeline.trail.controller.admin.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author liuxin
 */
@Setter
@Getter
@ToString
public class UpdateUserReq implements Serializable {
    @Size(min = 3, max = 15, message = "用户名长度必须在3-15个字符之间")
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "新密码不能为空")
    private String newPassword;
    @NotBlank(message = "旧密码不能为空")
    private String oldPassword;
}
