package com.thong.notificationservice.service.impl;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.thong.notificationservice.dto.NotificationDto;
import com.thong.notificationservice.entity.Notification;
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
    public String pushNotification(NotificationDto notificationDto) {
        Notification notification = objectMapper.map(notificationDto);

        notificationRepository.save(notification);

        Message msg = Message.builder()
                .setTopic(notification.getTopicId())
                .putData("content", notification.getContent())
                .build();

        try {
            return firebaseMessaging.send(msg);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
