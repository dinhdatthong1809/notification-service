package com.thong.notificationservice.service;

import com.thong.notificationservice.dto.PushToTopicRequest;
import com.thong.notificationservice.dto.SubscribeToTopicRequest;
import com.thong.notificationservice.dto.UnsubscribeToTopicRequest;

public interface NotificationService {

    void pushToTopic(PushToTopicRequest pushToTopicRequest);

    void subscribeToTopic(SubscribeToTopicRequest subscribeToTopicRequest);

    void unsubscribeToTopic(UnsubscribeToTopicRequest unsubscribeToTopicRequest);

}
