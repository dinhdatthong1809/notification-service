package com.thong.notificationservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UnsubscribeToTopicRequest {

    private String topicId;

    private List<String> registrationTokens;

}
