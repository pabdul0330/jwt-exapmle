package com.example.jwtexampleproject.dao.repository;

import com.example.jwtexampleproject.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "select * from users where username=:username limit 1",nativeQuery = true)
    Optional<UserEntity> findByUsername(@Param("username")String username);
}
