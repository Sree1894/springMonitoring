package com.monitoring.springMonitoring.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserSecurityExceptions extends RuntimeException {
        public UserSecurityExceptions(String message) {
            super(message);
        }

}
