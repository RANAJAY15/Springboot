package com.example.Employee.Services;


import com.example.Employee.Modules.RegisterDetails;
import com.example.Employee.Modules.Roles;
import com.example.Employee.Modules.UserDetailsDto;
import com.example.Employee.Repository.RegisterDetailsRepository;
import com.example.Employee.Repository.RegisterRepository;
import com.example.Employee.Repository.RolesRepository;
import com.example.Employee.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    RegisterRepository registerRepo;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String addNewEmployee(UserDetailsDto register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setName(register.getName());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setUserName(register.getUserName());
        Set<Roles> roles = new HashSet<>();
        for(String roleName: register.getRoleNames()){
            Roles role = rolesRepository.findByRoleName(roleName)
                    .orElseThrow(()->new RuntimeException("User not found" + roleName));
            roles.add(role);
        }
        registerDetails.setRoles(roles);
        System.out.println("Registration"+ registerDetails);
        registerDetailsRepository.save(registerDetails);
        return "Employee Added Successfully";
    }

    public String authenticate(RegisterDetails login) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(login.getUserName(),login.getPassword()));
        return jwtTokenProvider.generateToken(authentication);
    }

    public Optional<RegisterDetails> getUserByUsername(String username){
        return registerRepo.findByUserName(username);
    }


}
