package com.gidools.admin.repository;

import com.gidools.admin.AdminApplicationTests;
import com.gidools.admin.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryRepositoryTest extends AdminApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void create() {
        Category category = Category.builder()
                .createdAt(LocalDateTime.now())
                .createdBy("Jack")
                .type("Computer")
                .title("컴퓨터")
                .build();

        Category created = categoryRepository.save(category);

        assertNotNull(created);
        assertEquals(created.getType(), category.getType());
        assertEquals(created.getTitle(), category.getTitle());
    }

    @Test
    void read() {
        Optional<Category> category = categoryRepository.findByType("Computer");

        assertTrue(category.isPresent());

        category.ifPresent(c -> {
            assertEquals(c.getType(), "Computer");
            System.out.println("category : " + category);
        });
    }

}