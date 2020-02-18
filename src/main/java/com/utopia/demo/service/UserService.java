package com.utopia.demo.service;

import com.utopia.demo.dto.UserParam;
import com.utopia.demo.entity.User;
import com.utopia.demo.service.impl.UserDetailsImpl;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

    User getUserById(long id);

    @Transactional
    List<User> userListByUsername(String username, int pageSize, int pageNum);

    User updateUser(UserParam userParam);

    int deleteUser(long id);


    User register(UserParam user);

    String login(String username, String password);

    String refreshToken(String token);

    UserDetailsImpl loadUserByUsername(String username);
}
