package com.utopia.demo.service.impl;

import com.utopia.demo.component.JwtTokenUtil;
import com.utopia.demo.dto.UserParam;
import com.utopia.demo.entity.User;
import com.utopia.demo.repository.UserRepository;
import com.utopia.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Page<User> getAllUser(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);
        return userRepository.findAll(pageable);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(UserParam userParam) {
        if (userRepository.findExistUserUpdate(userParam.getId(), userParam.getUsername()) == null) {
            User user = new User();
            BeanUtils.copyProperties(userParam, user);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return user;
        }
        return null;
    }

    @Override
    public Boolean deleteUser(long id) {
        User user = userRepository.getOne(id);
        user.setState(false);
        userRepository.save(user);
        return true;
    }

    @Override
    public User register(UserParam user) {
        //查询同名用户
        System.out.println(userRepository.findByUsername(user.getUsername()));
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return null;
        }
        User user_new = new User();
        BeanUtils.copyProperties(user, user_new);

        user_new.setPassword(passwordEncoder.encode(user_new.getPassword()));
        userRepository.save(user_new);

        System.out.println("register success:" + user_new);
        return user_new;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetailsImpl userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("password is wrong");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
            System.out.println("login\nusername: " + username + " generate token " + token);

        } catch (AuthenticationException e) {
            System.out.println("login error" + e);
        }
        return token;
    }

    @Override
    public String refreshToken(String token) {
        return null;
    }

    @Override
    public UserDetailsImpl loadUserByUsername(String username) {
        User user = getUserByUsername(username);
        if (user != null) {

            return new UserDetailsImpl(user, null);
        }
        throw new UsernameNotFoundException("username or password is wrong");

    }
}
