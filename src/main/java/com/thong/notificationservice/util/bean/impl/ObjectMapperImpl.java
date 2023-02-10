package com.thong.notificationservice.util.bean.impl;

import com.thong.notificationservice.dto.PushToTopicRequest;
import com.thong.notificationservice.entity.Notification;
import com.thong.notificationservice.util.bean.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperImpl implements ObjectMapper {

    @Override
    public Notification map(PushToTopicRequest pushToTopicRequest) {
        var notification = new Notification();
        notification.setTopicId(pushToTopicRequest.getTopicId());
        notification.setTitle(pushToTopicRequest.getTitle());
        notification.setContent(pushToTopicRequest.getContent());
        return notification;
    }

}
