package com.ecomproject.projectA.repository;

import com.ecomproject.projectA.entity.User;
import com.ecomproject.projectA.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String email);

    User findByRole(UserRole userRole);
}
