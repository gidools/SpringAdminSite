package com.gidools.admin.repository;

import com.gidools.admin.AdminApplicationTests;
import com.gidools.admin.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

public class ItemRepositoryTest extends AdminApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void create() {
        Item item = Item.builder().name("노트북")
                .price(100000)
                .content("삼성노트북")
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
            System.out.println("item : " + i);
        });
    }

}