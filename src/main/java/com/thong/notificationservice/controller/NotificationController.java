package com.thong.notificationservice.controller;

import com.thong.notificationservice.dto.PushToTopicRequest;
import com.thong.notificationservice.dto.SubscribeToTopicRequest;
import com.thong.notificationservice.dto.UnsubscribeToTopicRequest;
import com.thong.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/topics/push")
    public ResponseEntity<Void> pushToTopic(@RequestBody PushToTopicRequest pushToTopicRequest) {
        notificationService.pushToTopic(pushToTopicRequest);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/topics/subscribe")
    public ResponseEntity<Void> subscribeToTopic(@RequestBody SubscribeToTopicRequest subscribeToTopicRequest) {
        notificationService.subscribeToTopic(subscribeToTopicRequest);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/topics/unsubscribe")
    public ResponseEntity<Void> unsubscribeToTopic(@RequestBody UnsubscribeToTopicRequest unsubscribeToTopicRequest) {
        notificationService.unsubscribeToTopic(unsubscribeToTopicRequest);
        return ResponseEntity.accepted().build();
    }

}
