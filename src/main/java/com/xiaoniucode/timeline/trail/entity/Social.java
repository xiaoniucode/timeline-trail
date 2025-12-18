package com.xiaoniucode.timeline.trail.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author liuxin
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "social")
public class Social implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String weibo;
    private String github;
    private String gitee;
    private String twitter;
    private String presume;
    private String site;
}
