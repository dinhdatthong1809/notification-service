package com.thong.notificationservice.controller;

import com.thong.notificationservice.dto.NotificationDto;
import com.thong.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notification/push")
    public ResponseEntity<String> pushNotification(@RequestBody NotificationDto notificationDto) {
        String id = notificationService.pushNotification(notificationDto);
        return ResponseEntity.accepted().body(id);
    }

}
