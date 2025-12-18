package com.xiaoniucode.timeline.trail.repository;

import com.xiaoniucode.timeline.trail.entity.Social;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liuxin
 */
@Repository
public interface SocialRepository extends JpaRepository<Social, Integer> {
}
