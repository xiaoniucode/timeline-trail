package com.xiaoniucode.timeline.trail.repository;

import com.xiaoniucode.timeline.trail.entity.Config;
import com.xiaoniucode.timeline.trail.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liuxin
 */
@Repository
public interface ConfigRepository extends JpaRepository<Config, Integer> {
}
