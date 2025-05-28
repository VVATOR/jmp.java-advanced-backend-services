package com.epam.jmp.jabs.module1.dto;

import com.epam.jmp.jabs.module1.constant.UserRoles;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public record LoginRequestDto(String login, List<UserRoles> roles) {
    @Override
    public List<UserRoles> roles() {
        return Optional.ofNullable(roles)
                .orElse(Collections.emptyList());
    }
}