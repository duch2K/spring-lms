package com.project.lms.service;

import com.project.lms.entity.Request;
import com.project.lms.model.RequestStatusEnum;

import java.util.Date;
import java.util.List;

public interface IRequestService {
    Request makeNewRequest(String login, Long bookId);
    List<Request> getByMemberLoginAndStatus(String login, RequestStatusEnum status);
    List<Request> getLastDateLessThanByMemberLogin(String login);
    List<Request> getLastDateLessThan();
    List<Request> getByStatus(RequestStatusEnum status);
}
