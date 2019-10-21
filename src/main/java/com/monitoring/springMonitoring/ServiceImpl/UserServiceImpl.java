package com.monitoring.springMonitoring.ServiceImpl;

import com.monitoring.springMonitoring.Model.Role;
import com.monitoring.springMonitoring.Model.User;
import com.monitoring.springMonitoring.Repositories.UserRepositories;
import com.monitoring.springMonitoring.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepositories userRepositories;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    public Optional<User> findById(String id) {

        return userRepositories.findById(id);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepositories.findByUserName(userName);
    }

    @Override
    public User saveUser(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        return userRepositories.save(user);
    }
}
