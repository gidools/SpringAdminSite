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
    @Transactional
    public void create() {
        User user = User.builder()
                .account("Jack")
                .email("Tester2@maxst.com")
                .phoneNumber("010-2206-3333")
                .createdAt(LocalDateTime.now())
                .createdBy("Tester3")
                .build();

        userRepository.save(user);
        System.out.println("new User : " + user);
    }

    @Test
    @Transactional
    public void read() {
        List<User> users = userRepository.findAll();
        System.out.println("users : " + users);
    }

    @Test
    @Transactional
    public void readById() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectedUser -> {
            System.out.println("user : " + selectedUser);
            System.out.println("email : " + selectedUser.getEmail());
        });
    }

    @Test
    @Transactional
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