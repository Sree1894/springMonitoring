package com.monitoring.springMonitoring.Security;

import com.monitoring.springMonitoring.Model.Role;
import com.monitoring.springMonitoring.Model.User;
import com.monitoring.springMonitoring.Repositories.RoleRepository;
import com.monitoring.springMonitoring.Repositories.UserRepositories;
import com.monitoring.springMonitoring.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    private UserRepositories userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;




    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        System.out.println("user obtained :" + userName);


        User user = userRepository.findByUserName(userName);

        if (user != null) {

            List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                    new SimpleGrantedAuthority("ROLE_" + role.getRole())
            ).collect(Collectors.toList());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }

    }


    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {

        return new UserPrincipal(user.getEmail(), user.getPassword(), authorities);
    }


}


