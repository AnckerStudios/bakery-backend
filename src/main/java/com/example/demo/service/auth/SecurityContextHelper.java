package com.example.demo.service.auth;

import com.example.demo.dto.auth.AccessTokenValue;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityContextHelper {
    public static AccessTokenValue getCurrentUser() {
        return (AccessTokenValue) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
