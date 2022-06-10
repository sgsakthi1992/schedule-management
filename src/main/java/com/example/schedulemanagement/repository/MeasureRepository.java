package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.domain.Measure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasureRepository extends JpaRepository<Measure, Long> {
}
