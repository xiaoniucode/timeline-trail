package com.xiaoniucode.timeline.trail;

import com.xiaoniucode.timeline.trail.entity.User;
import com.xiaoniucode.timeline.trail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 首次启动系统，如果没有用户则初始化一个默认的用户
 *
 * @author liuxin
 */
@Component
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            userRepository.save(createAdminUser());
        }
    }

    private User createAdminUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("$2a$10$xO3lJCiKQC1NS3pyWIt77OM.No5U3qh8lsmLlt0E/PSPgwBCz6w9q");
        return user;
    }
}
