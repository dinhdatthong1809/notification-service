package com.thong.notificationservice.util.bean;

import com.thong.notificationservice.dto.PushToTopicRequest;
import com.thong.notificationservice.entity.Notification;

public interface ObjectMapper {

    Notification map(PushToTopicRequest pushToTopicRequest);

}
