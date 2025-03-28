package com.example.music_lib.repository;

import com.example.music_lib.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u FROM User u WHERE u.email = :email")
    User getUserByEmail(@Param("email") String email);
}