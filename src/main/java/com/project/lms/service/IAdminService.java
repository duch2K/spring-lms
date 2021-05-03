package com.project.lms.service;

import com.project.lms.entity.Admin;

import java.util.List;

public interface IAdminService {
    List<Admin> getAll();
    boolean checkByUsernameAndPassword(String username, String password);
}
