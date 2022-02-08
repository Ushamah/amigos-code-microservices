package com.ushwamala.customer.service;

import com.ushwamala.customer.model.CustomerRegistrationRequest;
import com.ushwamala.customer.model.FraudCheckResponse;
import com.ushwamala.customer.model.customer;
import com.ushwamala.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              RestTemplate restTemplate) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        customer newCustomer = customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(newCustomer);

       // TODO:check if email is valid

       // TODO:check if email is not token

        //TODO:check if customer is fraudster
        FraudCheckResponse fraudCheckResponse =
                restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class, newCustomer.getId());

        assert fraudCheckResponse != null;
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

    }
}
