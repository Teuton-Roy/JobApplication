package com.example.JobApplication.Job.Implementation;

import com.example.JobApplication.Job.Job;
import com.example.JobApplication.Job.JobService;

import java.util.ArrayList;
import java.util.List;

public class JobServiceImpl implements JobService {
    private List<Job> jobs= new ArrayList<>();
    @Override
    public List<Job> findall() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }
}
