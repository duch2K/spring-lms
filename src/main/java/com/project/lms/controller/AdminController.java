package com.project.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.project.lms.entity.Admin;
import com.project.lms.service.implement.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    // GET
    @GetMapping("")
    public List<Admin> getAllAdmins() {
        return adminService.getAll();
    }

}
