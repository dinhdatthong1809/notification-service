package com.thong.notificationservice.service.impl;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.thong.notificationservice.dto.PushToTopicRequest;
import com.thong.notificationservice.dto.SubscribeToTopicRequest;
import com.thong.notificationservice.dto.UnsubscribeFromTopicRequest;
import com.thong.notificationservice.repository.NotificationRepository;
import com.thong.notificationservice.service.NotificationTopicService;
import com.thong.notificationservice.util.bean.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class NotificationTopicServiceImpl implements NotificationTopicService {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    @Transactional
    public void pushToTopic(PushToTopicRequest request) {
        var notification = objectMapper.map(request);
        notificationRepository.save(notification);

        var message = Message.builder()
                .setTopic(notification.getTopicId())
                .putData("content", notification.getContent())
                .build();

        firebaseMessaging.sendAsync(message);
    }

    @Override
    public void subscribeToTopic(SubscribeToTopicRequest request) {
        firebaseMessaging.subscribeToTopicAsync(request.getRegistrationTokens(), request.getTopicId());
    }

    @Override
    public void unsubscribeFromTopic(UnsubscribeFromTopicRequest request) {
        firebaseMessaging.unsubscribeFromTopicAsync(request.getRegistrationTokens(), request.getTopicId());
    }

}
