package com.example.Employee.Services;

import com.example.Employee.Modules.RegisterDetails;
import com.example.Employee.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    RegisterRepository registerRepo;

    public String createEmployee(RegisterDetails registerDetails) {
        registerRepo.save(registerDetails);
        return "Register Successfully";
    }
}
