package com.example.demo.service;

import com.example.demo.dto.IngredientPojo;
import com.example.demo.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final WebClient personWebClient;

    public Mono<String> findById() {
        return personWebClient.get()
                .uri(uriBuilder -> uriBuilder.path("/").build())
                .retrieve()
                .bodyToMono(String.class);
    }
}
