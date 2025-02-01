package com.microserviceproject.jobms.repository;

import com.microserviceproject.jobms.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
