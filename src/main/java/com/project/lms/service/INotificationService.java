package com.project.lms.service;

import com.project.lms.entity.Notification;
import com.project.lms.model.NotificationStatusEnum;

import java.util.List;

public interface INotificationService {
    void saveNotification(Notification notification);
    int getUnreadNotificationSizeByMemberLogin(String login);
    List<Notification> getByMemberLoginAndStatus(String login, NotificationStatusEnum status);
    void saveAll(List<Notification> notifications);
}
