package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.domain.ScheduleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleItemRepository extends JpaRepository<ScheduleItem, Long> {
}
