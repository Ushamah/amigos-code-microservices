package com.ushwamala.kafkaexample.domain;

import java.time.LocalDateTime;

public record Message(
        String message,
        LocalDateTime createdAt
) {
}
