package com.project.lms.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.lms.entity.Notification;
import com.project.lms.model.NotificationStatusEnum;
import com.project.lms.repository.NotificationRepository;
import com.project.lms.service.INotificationService;

import java.util.List;

@Service
public class NotificationService implements INotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void saveNotification(Notification notification) {
        notificationRepository.save(notification);
    }

    @Override
    public int getUnreadNotificationSizeByMemberLogin(String login) {
        return notificationRepository.countNotificationsByMember_LoginAndStatus(login, NotificationStatusEnum.UNREAD);
    }

    @Override
    public List<Notification> getByMemberLoginAndStatus(String login, NotificationStatusEnum status) {
        return notificationRepository.getNotificationsByMember_LoginAndStatus(login, status);
    }

    @Override
    public void saveAll(List<Notification> notifications) {
        notificationRepository.saveAll(notifications);
    }
}
