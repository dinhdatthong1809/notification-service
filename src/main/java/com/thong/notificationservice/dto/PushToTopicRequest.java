package com.thong.notificationservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PushToTopicRequest {

    private String topicId;

    private String title;

    private String content;

}
