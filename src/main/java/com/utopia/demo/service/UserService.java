package com.utopia.demo.service;

import com.utopia.demo.dto.UserParam;
import com.utopia.demo.entity.User;
import com.utopia.demo.service.impl.UserDetailsImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

    User getUserById(long id);

    @Transactional
    Page<User> getAllUser(int pageNum, int pageSize);

    User updateUser(UserParam userParam);

    Boolean deleteUser(long id);

    User register(UserParam user);

    String login(String username, String password);

    String refreshToken(String token);

    UserDetailsImpl loadUserByUsername(String username);
}
