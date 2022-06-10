package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.domain.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScenarioRepository extends JpaRepository<Scenario, Long> {
}
