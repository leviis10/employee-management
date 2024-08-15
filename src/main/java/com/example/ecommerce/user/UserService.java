package com.example.ecommerce.user;

import com.example.ecommerce.auth.dto.RegisterDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    String create(RegisterDTO request);
}
