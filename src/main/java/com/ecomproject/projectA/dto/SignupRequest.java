package com.ecomproject.projectA.dto;

import com.ecomproject.projectA.entity.UserRole;
import lombok.Data;

@Data
public class SignupRequest {

    private String email;

    private String password;

    private String name;

    private UserRole userRole;
}
