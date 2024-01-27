package com.example.transaction.dtos;

import com.example.transaction.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(
        String firstName,
        String lastName,
        String document,
        BigDecimal balance,
        String email,
        String password,
        UserType userType
) {
}
