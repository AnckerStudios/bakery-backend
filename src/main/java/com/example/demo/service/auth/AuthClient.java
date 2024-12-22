package com.example.demo.service.auth;

import com.example.demo.dto.auth.AccessTokenValue;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface AuthClient {
    Mono<AccessTokenValue> getValueByToken(String jwtToken);
}
