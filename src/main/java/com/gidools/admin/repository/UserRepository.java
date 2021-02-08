package com.gidools.admin.repository;

import com.gidools.admin.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByPhoneNumberOrderById(String phoneNumber);
}
