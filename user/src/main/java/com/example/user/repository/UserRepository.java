package com.example.user.repository;

import com.example.user.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Page<UserEntity> findAll(Pageable pageable);

    Page<UserEntity> findAllByName(String name, Pageable pageable);
}
