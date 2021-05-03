package com.project.lms.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.lms.entity.Admin;
import com.project.lms.repository.AdminRepository;
import com.project.lms.service.IAdminService;

import java.util.List;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getAll() {
        return adminRepository.getAdminsBy();
    }

    @Override
    public boolean checkByUsernameAndPassword(String username, String password) {
        return adminRepository.existsAdminByUsernameAndPassword(username, password);
    }
}
