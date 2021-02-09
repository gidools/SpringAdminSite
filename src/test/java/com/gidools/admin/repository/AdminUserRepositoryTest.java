package com.gidools.admin.repository;

import com.gidools.admin.AdminApplicationTests;
import com.gidools.admin.model.entity.AdminUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AdminUserRepositoryTest extends AdminApplicationTests {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    void create() {
        AdminUser adminUser = AdminUser.builder()
                .account("Admin01")
                .password("admin0101")
                .status("Registered")
                .role("Partner")
                .createdAt(LocalDateTime.now())
                .createdBy("Jack")
                .build();

        AdminUser created = adminUserRepository.save(adminUser);

        Assertions.assertNotNull(created);
    }
}