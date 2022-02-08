package com.ushwamala.clients.notification;

import lombok.Builder;


public record NotificationRequest(Integer toCustomerId,
                                  String toCustomerName,
                                  String message) {
}
