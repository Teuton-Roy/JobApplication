package com.example.JobApplication.Job.Implementation;

import com.example.JobApplication.Job.Job;
import com.example.JobApplication.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service                                                                   //It tells that this class is a service
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
