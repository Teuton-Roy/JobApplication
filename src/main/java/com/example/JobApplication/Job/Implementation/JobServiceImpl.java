package com.example.JobApplication.Job.Implementation;

import com.example.JobApplication.Job.Job;
import com.example.JobApplication.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service                                                                   //It tells that this class is a service
public class JobServiceImpl implements JobService {
    private List<Job> jobs= new ArrayList<>();
    private long nextId = 1L;         //This variable which used to keep track of job_id that I have in my application.
                                      //Also, this will help with no duplicate job_id in my job[every I create new job, job_id will be unique].

    @Override
    public List<Job> findall() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);      //It will do is, set current id to job object then it will increment by 1.
        jobs.add(job);
    }
}
