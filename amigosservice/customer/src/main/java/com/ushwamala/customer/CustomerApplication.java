package com.ushwamala.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(
      scanBasePackages = {
              "com.ushwamala.customer",
              "com.ushwamala.amqp"
      }
)
@EnableEurekaClient //Shows that it is a eureka client
@EnableFeignClients(basePackages = "com.ushwamala.clients") //This is where the feign-clients are stored
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
