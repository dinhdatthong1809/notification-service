package com.thong.notificationservice.util.bean;

import com.thong.notificationservice.dto.NotificationDto;
import com.thong.notificationservice.entity.Notification;

public interface ObjectMapper {

    Notification map(NotificationDto notificationDto);

}
