package com.epam.jmp.jabs.module1.controller;

import com.epam.jmp.jabs.module1.dto.LoginRequestDto;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private static final String SELF_ISSUER = "self";
    private static final String CLAIM_ROLES = "roles";
    private static final long JWT_EXPIRATION = 3600L;

    private final JwtEncoder jwtEncoder;

    public AuthController(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequest) {
        final var now = Instant.now();
        final var claims = JwtClaimsSet.builder()
                .issuer(SELF_ISSUER)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(JWT_EXPIRATION))
                .subject(loginRequest.login())
                .claim(CLAIM_ROLES, loginRequest.roles())
                .build();
        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}