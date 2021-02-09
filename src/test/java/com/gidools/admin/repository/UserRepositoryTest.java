package com.gidools.admin.repository;

import com.gidools.admin.AdminApplicationTests;
import com.gidools.admin.enumclass.UserStatus;
import com.gidools.admin.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends AdminApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void create() {
        User user = User.builder()
                .account("Tester1")
                .password("testtest")
                .status(UserStatus.REGISTERED)
                .email("Tester1@maxst.com")
                .phoneNumber("010-2206-3333")
                .registeredAt(LocalDateTime.now())
                .build();

        User created = userRepository.save(user);

        Assertions.assertNotNull(created);
    }

    @Test
    @Transactional
    public void read() {
        User user = userRepository.findFirstByPhoneNumberOrderById("010-2206-2222");
        user.getOrderGroupList().forEach(orderGroup -> {
            System.out.println(orderGroup.getTotalPrice());
            System.out.println(orderGroup.getRevAddress());
            System.out.println(orderGroup.getRevName());

            System.out.println("-------------------주문상세----------------");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("Order detail: " + orderDetail);
                System.out.println("주문 상품 : " + orderDetail.getItem());
                System.out.println("파트너 : " + orderDetail.getItem().getPartner());
                System.out.println("카테고리 : " + orderDetail.getItem().getPartner().getCategory());
            });
        });

        System.out.println("user : " + user);

        Assertions.assertNotNull(user);
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