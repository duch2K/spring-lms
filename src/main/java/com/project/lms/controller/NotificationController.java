package com.project.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.project.lms.entity.Notification;
import com.project.lms.model.NotificationStatusEnum;
import com.project.lms.service.implement.NotificationService;

import java.util.List;

@Controller
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    public void saveNotification(Notification notification) {
        notificationService.saveNotification(notification);
    }

    public int getCountUnreadByMember_Login(String login) {
        return notificationService.getUnreadNotificationSizeByMemberLogin(login);
    }

    public List<Notification> getByMemberLoginAndStatus(String login, NotificationStatusEnum status) {
        return notificationService.getByMemberLoginAndStatus(login, status);
    }

    public void changeNotificationsStatusToRead(List<Notification> notifications) {
        for (int i = 0; i < notifications.size(); i++) {
            notifications.get(i).setStatus(NotificationStatusEnum.READ);
        }

        notificationService.saveAll(notifications);
    }
}
