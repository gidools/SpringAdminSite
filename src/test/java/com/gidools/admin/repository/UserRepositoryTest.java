package com.gidools.admin.repository;

import com.gidools.admin.AdminApplicationTests;
import com.gidools.admin.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class UserRepositoryTest extends AdminApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = User.builder()
                .account("Tester1")
                .password("testtest")
                .status("Registered")
                .email("Tester1@maxst.com")
                .phoneNumber("010-2206-2222")
                .registeredAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("Jack")
                .build();

        User created = userRepository.save(user);

        Assertions.assertNotNull(created);
    }

    @Test
    public void read() {
        User user = userRepository.findFirstByPhoneNumberOrderById("010-2206-2222");

        System.out.println("user : " + user);

        Assertions.assertNotNull(user);
    }

    @Test
    @Transactional
    public void readById() {
        // select * from user where id = ?
//        Optional<User> user = userRepository.findByAccount("Jack");
//
//        user.ifPresent(selectedUser -> {
//            selectedUser.getOrderDetailList().forEach(detail -> {
//                System.out.println("Item : " + detail.getItem());
//            });
//        });
    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(3L);

        user.ifPresent(selectedUser -> {
            selectedUser.setAccount("User3");
            selectedUser.setUpdatedAt(LocalDateTime.now());
            selectedUser.setUpdatedBy("King");
            userRepository.save(selectedUser);
        });
    }

    @Test
    @Transactional
    void delete() {
        Optional<User> user = userRepository.findById(5L);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(selectedUser -> userRepository.delete(selectedUser));

        Optional<User> deletedUser = userRepository.findById(5L);

        Assertions.assertFalse(deletedUser.isPresent());
    }

}