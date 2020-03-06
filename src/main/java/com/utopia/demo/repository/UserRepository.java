package com.utopia.demo.repository;

import com.utopia.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    User findByUsername(String username);

    @Override
    Page<User> findAll(Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.id <> ?1 and u.username=?2")
    User findExistUserUpdate(long id, String username);

}
