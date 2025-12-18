package com.xiaoniucode.timeline.trail.entity;



import lombok.*;

import java.io.Serializable;

/**
 * @author liuxin
 */
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class LoginUser implements Serializable {
    private Integer userId;
    private String username;
}
