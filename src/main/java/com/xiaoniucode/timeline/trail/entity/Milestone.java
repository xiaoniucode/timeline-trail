package com.xiaoniucode.timeline.trail.entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 里程碑实体（JSON存储）
 * @author liuxin
 */
@Entity
@Setter
@Getter
@ToString
@Table(name = "milestone")
public class Milestone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    /**
     * 中文JSON数据
     */
    @Lob
    @JsonRawValue
    @Column(name = "zh", columnDefinition = "TEXT")
    private String zh;

    /**
     * 英文JSON数据
     */
    @Lob
    @JsonRawValue
    @Column(name = "en", columnDefinition = "TEXT")
    private String en;
}
