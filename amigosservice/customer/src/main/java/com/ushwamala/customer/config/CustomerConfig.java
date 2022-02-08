package com.ushwamala.customer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

    @Bean
    @LoadBalanced //Allows the request to go one of the instances running
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
