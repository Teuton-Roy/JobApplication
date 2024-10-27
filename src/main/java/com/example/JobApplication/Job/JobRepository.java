package com.example.JobApplication.Job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long>{   //<Entity type, primary key type>

}
