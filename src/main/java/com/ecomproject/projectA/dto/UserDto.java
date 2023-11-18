package com.ecomproject.projectA.dto;

import com.ecomproject.projectA.entity.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String email;

    private String password;

    private String name;

    private UserRole role;


    private byte[] img;
}
