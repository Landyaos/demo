package com.utopia.demo.repository;

import com.utopia.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);


    User findByUsername(String username);

}
