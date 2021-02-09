package com.gidools.admin.repository;

import com.gidools.admin.AdminApplicationTests;
import com.gidools.admin.model.entity.Partner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PartnerRepositoryTest extends AdminApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    void create() {
        Partner partner = Partner.builder()
                .name("Partner01")
                .status("Registered")
                .address("서울시 강남구")
                .callCenter("070-1111-2222")
                .partnerNumber("010-1111-2222")
                .businessNumber("012-3456-7890123")
                .ceoName("권기석")
                .createdAt(LocalDateTime.now())
                .createdBy("Jack")
                .build();

        Partner created = partnerRepository.save(partner);

        Assertions.assertNotNull(created);
        Assertions.assertEquals(created.getName(), partner.getName());
    }

}