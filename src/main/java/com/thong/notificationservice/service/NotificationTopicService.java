package com.thong.notificationservice.service;

import com.thong.notificationservice.dto.PushToTopicRequest;
import com.thong.notificationservice.dto.SubscribeToTopicRequest;
import com.thong.notificationservice.dto.UnsubscribeFromTopicRequest;

public interface NotificationTopicService {

    void pushToTopic(PushToTopicRequest request);

    void subscribeToTopic(SubscribeToTopicRequest request);

    void unsubscribeFromTopic(UnsubscribeFromTopicRequest request);

}
