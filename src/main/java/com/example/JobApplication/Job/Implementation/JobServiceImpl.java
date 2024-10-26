package com.example.JobApplication.Job.Implementation;

import com.example.JobApplication.Job.Job;
import com.example.JobApplication.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service                                                                   //It tells that this class is a service
public class JobServiceImpl implements JobService {
    
    private final List<Job> jobs= new ArrayList<>();

    private long nextId = 1L;         //This variable which used to keep track of job_id that I have in my application.
                                      //Also, this will help with no duplicate job_id in my job[every I create new job, job_id will be unique].


    //Implement find all jobs
    @Override
    public List<Job> findall() {
        return jobs;
    }


    //Implement create jobs
    @Override
    public void createJob(Job job) {
        job.setId(nextId++);      //It will do is, set current id to job object then it will increment by 1.
        jobs.add(job);
    }


    //Implement getJobById
    @Override
    public Job getJobById(Long id) {
        for(Job job: jobs){
            if(job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }


    //Implement DeleteJobById
    @Override
    public boolean DeleteJobById(Long id) {
        Iterator<Job> it = jobs.iterator(); //with the help of Iterator I travers through the list and fetching every
        while (it.hasNext()){               //object present in the list.
            Job job = it.next();            //Then assign it to job object
            if(job.getId().equals(id)){     //compare the ID
                it.remove();                //if ID matched then delete and return TRUE...
                return true;
            }
        }
        return false;
    }
}
