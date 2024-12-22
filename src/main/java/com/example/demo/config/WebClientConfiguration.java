package com.example.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfiguration {
    @Value("${auth.baseUrl:http://BAKERY-AUTH}")
    private String baseUrl;

    @Value("${person.personUrl:http://A-NODE-SERVICE}")
    private String personUrl;

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public WebClient authWebClient() {
        return loadBalancedWebClientBuilder()
                .baseUrl(baseUrl)
                .build();
    }

    @Bean
    public WebClient personWebClient() {
        return loadBalancedWebClientBuilder()
                .baseUrl(personUrl)
                .build();
    }
}
