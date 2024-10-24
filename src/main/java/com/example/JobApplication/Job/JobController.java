package com.example.JobApplication.Job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class JobController {

    //Defining job controller here...

//    private List<Job> jobs= new ArrayList<>(); //List of jobs

    private JobService jobservice;  //job_service will be available at runtime, and inject it to job_controller

    //constructor
    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    //Get list of jobs
    @GetMapping("/jobs")
    public List<Job> findAll(){ //this the endpoint we are creating here which return all the jobs
        return jobservice.findall();
    }

    //Create a new job
    @PostMapping("/jobs")
    public String CreateJob(@RequestBody Job job){
         //this the endpoint we are creating here which return all the jobs
        jobservice.createJob(job);
        return "Job added successfully";
    }
}


