package com.thong.notificationservice.service;

import com.thong.notificationservice.dto.NotificationDto;

public interface NotificationService {

    String pushNotification(NotificationDto notificationDto);

}
