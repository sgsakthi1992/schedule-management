package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.domain.Period;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodRepository extends JpaRepository<Period, Long> {
}
