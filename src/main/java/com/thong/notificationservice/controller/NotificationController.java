package com.thong.notificationservice.controller;

import com.thong.notificationservice.dto.PushToTopicRequest;
import com.thong.notificationservice.dto.SubscribeToTopicRequest;
import com.thong.notificationservice.dto.UnsubscribeFromTopicRequest;
import com.thong.notificationservice.service.NotificationTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationTopicService notificationTopicService;

    @PostMapping("/topics/push")
    public ResponseEntity<Void> pushToTopic(@RequestBody PushToTopicRequest request) {
        notificationTopicService.pushToTopic(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/topics/subscribe")
    public ResponseEntity<Void> subscribeToTopic(@RequestBody SubscribeToTopicRequest request) {
        notificationTopicService.subscribeToTopic(request);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/topics/unsubscribe")
    public ResponseEntity<Void> unsubscribeFromTopic(@RequestBody UnsubscribeFromTopicRequest request) {
        notificationTopicService.unsubscribeFromTopic(request);
        return ResponseEntity.accepted().build();
    }

}
