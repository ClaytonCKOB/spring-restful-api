package com.example.transaction.dtos;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long senderId) {
}