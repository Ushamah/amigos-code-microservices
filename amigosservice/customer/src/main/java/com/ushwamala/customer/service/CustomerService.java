package com.ushwamala.customer.service;

import com.ushwamala.amqp.config.RabbitMQMessageProducer;
import com.ushwamala.clients.fraud.FraudCheckResponse;
import com.ushwamala.clients.fraud.FraudClient;
import com.ushwamala.clients.notification.NotificationRequest;
import com.ushwamala.customer.model.CustomerRegistrationRequest;
import com.ushwamala.customer.model.customer;
import com.ushwamala.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              RestTemplate restTemplate,
                              FraudClient fraudClient,
                              RabbitMQMessageProducer rabbitMQMessageProducer) {
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
        final FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(newCustomer.getId());


        assert fraudCheckResponse != null;
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                newCustomer.getId(),
                newCustomer.getEmail(),
                String.format("Hi %s, welcome to Amigos service...", newCustomer.getFirstName())
        );

        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
