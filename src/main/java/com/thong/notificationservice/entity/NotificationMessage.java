package com.thong.notificationservice.entity;

import com.thong.notificationservice.entity.abstraction.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "notification_message")
@Getter
@Setter
public class NotificationMessage extends AbstractEntity {

    @Id
    private Long id;

    private String content;

}
