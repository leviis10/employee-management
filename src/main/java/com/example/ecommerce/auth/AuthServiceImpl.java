package com.example.ecommerce.auth;

import com.example.ecommerce.auth.dto.LoginDTO;
import com.example.ecommerce.auth.dto.RegisterDTO;
import com.example.ecommerce.common.security.JwtUtils;
import com.example.ecommerce.user.User;
import com.example.ecommerce.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserService userService;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Override
    public String login(LoginDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        return jwtUtils.generateToken(request.getUsername());
    }

    @Override
    public String register(RegisterDTO request) {
        String username = userService.create(request);
        return jwtUtils.generateToken(username);
    }
}
