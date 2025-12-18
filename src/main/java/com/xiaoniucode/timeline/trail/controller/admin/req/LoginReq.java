package com.xiaoniucode.timeline.trail.controller.admin.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
/**
 * @author liuxin
 */
@Setter
@Getter
@ToString
public class LoginReq implements Serializable {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
