package com.project.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.lms.entity.Notification;
import com.project.lms.model.NotificationStatusEnum;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Integer countNotificationsByMember_LoginAndStatus(String login, NotificationStatusEnum status);
    List<Notification> getNotificationsByMember_LoginAndStatus(String login, NotificationStatusEnum status);
}
