package com.gidools.admin.repository;

import com.gidools.admin.AdminApplicationTests;
import com.gidools.admin.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends AdminApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    void create() {
        OrderDetail orderDetail = OrderDetail.builder()
                .status("registered")
                .arrivalDate(LocalDateTime.now().plusDays(2))
                .quantity(10)
                .totalPrice(BigDecimal.valueOf(900000))
                .createdAt(LocalDateTime.now())
                .createdBy("Jack")
                .build();

        OrderDetail created = orderDetailRepository.save(orderDetail);

        Assertions.assertNotNull(created);
        System.out.println("OrderDetail " + created);
    }

}