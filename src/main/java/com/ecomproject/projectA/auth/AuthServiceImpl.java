package com.ecomproject.projectA.auth;

import com.ecomproject.projectA.dto.SignupRequest;
import com.ecomproject.projectA.dto.UserDto;
import com.ecomproject.projectA.entity.User;
import com.ecomproject.projectA.entity.UserRole;
import com.ecomproject.projectA.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        User createdUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        userDto.setEmail(createdUser.getEmail());
        userDto.setName(createdUser.getName());
        return userDto;
    }
public boolean hasUserWithEmail(String email ){
        return userRepository.findFirstByEmail(email).isPresent();
}
@PostConstruct
public void createAdminAccount(){
        User adminAcount = userRepository.findByRole(UserRole.ADMIN);
        if(null == adminAcount){
            User user = new User();
            user.setEmail("admin@test.com");
            user.setName("admin");
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin123"));
            userRepository.save(user);
        }
}
}
