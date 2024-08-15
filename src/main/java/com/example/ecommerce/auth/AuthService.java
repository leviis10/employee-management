package com.example.ecommerce.auth;

import com.example.ecommerce.auth.dto.LoginDTO;
import com.example.ecommerce.auth.dto.RegisterDTO;

public interface AuthService {
    String login(LoginDTO request);

    String register(RegisterDTO request);
}
