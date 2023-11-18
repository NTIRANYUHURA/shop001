package com.ecomproject.projectA.auth;

import com.ecomproject.projectA.dto.SignupRequest;
import com.ecomproject.projectA.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}
