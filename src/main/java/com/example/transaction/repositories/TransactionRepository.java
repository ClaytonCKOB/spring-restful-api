package com.example.transaction.repositories;

import com.example.transaction.domain.transaction.Transaction;
import com.example.transaction.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
