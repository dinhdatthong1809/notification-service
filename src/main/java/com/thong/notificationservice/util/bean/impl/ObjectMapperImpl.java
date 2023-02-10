package com.thong.notificationservice.util.bean.impl;

import com.thong.notificationservice.dto.NotificationDto;
import com.thong.notificationservice.entity.Notification;
import com.thong.notificationservice.util.bean.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperImpl implements ObjectMapper {

    public Notification map(NotificationDto notificationDto) {
        var notification = new Notification();
        notification.setContent(notificationDto.getContent());
        notification.setTopicId(notificationDto.getTopicId());
        return notification;
    }

}
