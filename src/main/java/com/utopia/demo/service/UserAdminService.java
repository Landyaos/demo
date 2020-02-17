package com.utopia.demo.service;

import com.utopia.demo.entity.User;
import com.utopia.demo.service.impl.UserDetailsImpl;

import javax.transaction.Transactional;
import java.util.List;

public interface UserAdminService {

    User getUserByUsername(String username);

    User getUserById(int id);

    @Transactional
    List<User> userListByUsername(String username, int pageSize, int pageNum);

    int updateUser(int id, User user);

    int deleteUser(int id);



    User register(User user);

    String login(String username, String password);

    String refreshToken(String token);


    UserDetailsImpl loadUserByUsername(String username);
}
