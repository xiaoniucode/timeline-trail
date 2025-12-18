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
@Table(name = "config")
public class Config implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String background;
    private String description;
    private String avatar;
    private String copyright;
    private String author;
    private String favicon;
    private String keywords;
    private String robots;
}
