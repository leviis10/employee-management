package com.example.ecommerce.auth;

import com.example.ecommerce.auth.dto.LoginDTO;
import com.example.ecommerce.auth.dto.RegisterDTO;
import com.example.ecommerce.common.response.Response;
import com.example.ecommerce.common.response.SuccessResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<SuccessResponse<String>> register(
            @Valid @RequestBody RegisterDTO request
    ) {
        return Response.success(
                HttpStatus.CREATED,
                authService.register(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessResponse<String>> login(
            @Valid @RequestBody LoginDTO request
    ) {
        return Response.success(
                HttpStatus.OK,
                authService.login(request)
        );
    }
}
