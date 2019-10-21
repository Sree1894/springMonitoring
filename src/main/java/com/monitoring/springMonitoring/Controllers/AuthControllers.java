package com.monitoring.springMonitoring.Controllers;

import com.monitoring.springMonitoring.Enums.ApiResponseEnums;
import com.monitoring.springMonitoring.Exceptions.UserSecurityExceptions;
import com.monitoring.springMonitoring.Model.User;
import com.monitoring.springMonitoring.PayLoad.ApiResponse;
import com.monitoring.springMonitoring.Security.JwtTokenProvider;
import com.monitoring.springMonitoring.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthControllers {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserService userService;


    @PostMapping("/signin")
    public ApiResponse userSignIn(@RequestParam String userName, @RequestParam String password) {

        try {
            Authentication authentication = authenticationManager.authenticate(new
                    UsernamePasswordAuthenticationToken(userName, password));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtTokenProvider.generateToken(authentication);
            User user = userService.findByUserName(userName);

            System.out.println("user obtained :" + user.getUserName());
            return new ApiResponse(ApiResponseEnums.API_RESPONSE_SUCCESS.getCode(), true, jwt, user);

        } catch (UserSecurityExceptions e) {

            return new ApiResponse(ApiResponseEnums.API_RESPONSE_SUCCESS.getCode(),
                    true, ApiResponseEnums.API_RESPONSE_SUCCESS.getMessage(), null);

        }
    }


    @PostMapping("/signup")
    public ApiResponse signup(@RequestBody User user) {

        if (user!=null){
            userService.saveUser(user);
            return new ApiResponse(ApiResponseEnums.API_RESPONSE_SUCCESS.getCode(),
                    true, ApiResponseEnums.API_RESPONSE_SUCCESS.getMessage(), user);
        }
        return new ApiResponse(ApiResponseEnums.API_RESPONSE_FAILED.getCode(),
                true, ApiResponseEnums.API_RESPONSE_FAILED.getMessage(), null);

    }
}
