package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.domain.ScheduleLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleLineItemRepository extends JpaRepository<ScheduleLineItem, Long> {
}
