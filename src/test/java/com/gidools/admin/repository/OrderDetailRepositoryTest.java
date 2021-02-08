package com.gidools.admin.repository;

import com.gidools.admin.AdminApplicationTests;
import com.gidools.admin.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends AdminApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    void create() {
        OrderDetail orderDetail = OrderDetail.builder()
                .orderAt(LocalDateTime.now())
                .userId(1L)
                .itemId(1L)
                .build();

        OrderDetail created = orderDetailRepository.save(orderDetail);

        Assertions.assertNotNull(created);
    }

}