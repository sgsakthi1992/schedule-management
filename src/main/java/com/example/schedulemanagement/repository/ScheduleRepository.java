package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
