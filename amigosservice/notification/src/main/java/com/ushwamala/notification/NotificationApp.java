package com.ushwamala.notification;

import com.ushwamala.amqp.config.RabbitMQMessageProducer;
import com.ushwamala.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(
        //This enables all classes in the amqp module to be used in the notification module
        scanBasePackages = {
                "com.ushwamala.notification",
                "com.ushwamala.amqp"
        }
)
@EnableEurekaClient
public class NotificationApp {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApp.class, args);
    }

   /* CommandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig) {
        return args ->
                producer.publish(new Person("Ushamah", 29),
                notificationConfig.getInternalExchange(),
                notificationConfig.getInternalNotificationRoutingKey());
    }

    record Person(String name, int age) {
    }*/
}
