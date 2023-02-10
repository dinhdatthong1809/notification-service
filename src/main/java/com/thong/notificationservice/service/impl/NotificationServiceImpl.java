package com.thong.notificationservice.service.impl;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.thong.notificationservice.dto.PushToTopicRequest;
import com.thong.notificationservice.dto.SubscribeToTopicRequest;
import com.thong.notificationservice.dto.UnsubscribeToTopicRequest;
import com.thong.notificationservice.repository.NotificationRepository;
import com.thong.notificationservice.service.NotificationService;
import com.thong.notificationservice.util.bean.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    @Transactional
    public void pushToTopic(PushToTopicRequest pushToTopicRequest) {
        var notification = objectMapper.map(pushToTopicRequest);
        notificationRepository.save(notification);

        var message = Message.builder()
                .setTopic(notification.getTopicId())
                .putData("content", notification.getContent())
                .build();

        firebaseMessaging.sendAsync(message);
    }

    @Override
    public void subscribeToTopic(SubscribeToTopicRequest subscribeToTopicRequest) {
        firebaseMessaging.subscribeToTopicAsync(subscribeToTopicRequest.getRegistrationTokens(), subscribeToTopicRequest.getTopicId());
    }

    @Override
    public void unsubscribeToTopic(UnsubscribeToTopicRequest unsubscribeToTopicRequest) {
        firebaseMessaging.unsubscribeFromTopicAsync(unsubscribeToTopicRequest.getRegistrationTokens(), unsubscribeToTopicRequest.getTopicId());
    }

}
