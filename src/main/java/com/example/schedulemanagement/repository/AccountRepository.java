package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
