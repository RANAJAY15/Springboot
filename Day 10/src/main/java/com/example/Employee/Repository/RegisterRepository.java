package com.example.Employee.Repository;

import com.example.Employee.Modules.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterRepository extends JpaRepository<RegisterDetails,Integer> {
    Optional<RegisterDetails> findByUserName(String username);
}

