package com.monitoring.springMonitoring.Repositories;

import com.monitoring.springMonitoring.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepositories extends MongoRepository<User,String> {

    User findByUserName(String username);

}
