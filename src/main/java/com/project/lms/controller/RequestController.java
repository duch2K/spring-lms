package com.project.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.lms.entity.Request;
import com.project.lms.model.PostDataForRequest;
import com.project.lms.model.RequestStatusEnum;
import com.project.lms.service.implement.RequestService;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {
    @Autowired
    private RequestService requestService;

    // GET
    @GetMapping("")
    public List<Request> getRequestByMemberLoginAndStatus(
            @RequestParam("memberLogin") String login,
            @RequestParam("status") RequestStatusEnum status
    ) {
        return requestService.getByMemberLoginAndStatus(login, status);
    }

    @GetMapping("/over-due-date")
    public List<Request> getByLastDateLessThan() {
        return requestService.getLastDateLessThan();
    }

    @GetMapping("/over-due-date/{memberLogin}")
    public List<Request> getByMemberLoginAndStatusIsAndLastDateLessThan(@PathVariable("memberLogin") String login) {
        return requestService.getLastDateLessThanByMemberLogin(login);
    }

    // POST
    @PostMapping("")
    public Request makeNewRequest(@RequestBody PostDataForRequest data) {
        return requestService.makeNewRequest(data.memberLogin, data.bookId);
    }

    // PATCH
    @PatchMapping("/{id}")
    public Request changeRequestStatus(@PathVariable("id") Long id, @RequestParam("status") RequestStatusEnum status) {
        if (status == RequestStatusEnum.ISSUE) {
            return requestService.changeStatusToIssue(id);
        }
        return requestService.changeStatusToReturn(id);
    }
}
