package com.utopia.demo.repository;

import com.utopia.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);


    User findByUsername(String username);

}
