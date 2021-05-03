package com.project.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.lms.entity.Request;
import com.project.lms.model.RequestStatusEnum;

import java.util.Date;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> getRequestByMember_LoginAndStatusIs(String login, RequestStatusEnum status);
    List<Request> getRequestsByMember_LoginAndStatusAndLastDateLessThan(String login, RequestStatusEnum status, Date date);
    List<Request> getRequestsByStatusAndLastDateLessThan(RequestStatusEnum status, Date date);
    List<Request> getRequestByStatus(RequestStatusEnum status);
    Request getRequestById(Long id);
}
