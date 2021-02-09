package com.gidools.admin.repository;

import com.gidools.admin.AdminApplicationTests;
import com.gidools.admin.model.entity.OrderGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class OrderGroupRepositoryTest extends AdminApplicationTests {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    void create() {
        OrderGroup orderGroup = OrderGroup.builder()
                .orderAt(LocalDateTime.now())
                .orderType("All")
                .revAddress("강남구")
                .revName("권기석")
                .paymentType("카드")
                .totalPrice(BigDecimal.valueOf(900000))
                .totalQuantity(1)
                .orderAt(LocalDateTime.now().minusDays(2))
                .status("Complete")
                .arrivalDate(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("Jack")
                .userId(1L)
                .build();

        OrderGroup created = orderGroupRepository.save(orderGroup);

        Assertions.assertNotNull(created);
    }
}