package com.gidools.admin.repository;

import com.gidools.admin.AdminApplicationTests;
import com.gidools.admin.enumclass.ItemStatus;
import com.gidools.admin.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends AdminApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @Transactional
    void create() {
        Item item = Item.builder().name("노트북")
                .status(ItemStatus.REGISTERED)
                .name("삼성노트북")
                .title("삼성 노트북 그램")
                .content("2021년형 노트북입니다.")
                .price(1000000)
                .brandName("삼성")
                .registeredAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("Partner01")
                .build();

        Item created = itemRepository.save(item);

        Assertions.assertNotNull(created);
    }

    @Test
    @Transactional
    void read() {
        Optional<Item> item = itemRepository.findById(1L);

        Assertions.assertTrue(item.isPresent());

        item.ifPresent(i -> {
            i.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("Order detail : " + orderDetail);
            });
        });
    }

}