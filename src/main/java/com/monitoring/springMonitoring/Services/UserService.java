package com.monitoring.springMonitoring.Services;

import com.monitoring.springMonitoring.Model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(String empid);

    User findByUserName(String userName);

    User saveUser(User user);
}
