package com.thong.notificationservice.controller;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    @PostMapping("/topics/{topic}")
    public ResponseEntity<String> postToTopic(@RequestBody String message, @PathVariable String topic) throws FirebaseMessagingException {

        Message msg = Message.builder()
                .setTopic(topic)
                .putData("body", message)
                .build();

        String id = firebaseMessaging.send(msg);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
    }

}
