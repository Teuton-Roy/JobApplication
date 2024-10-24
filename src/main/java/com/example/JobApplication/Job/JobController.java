package com.example.JobApplication.Job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class JobController {

    //Defining job controller here...

    private List<Job> jobs= new ArrayList<>(); //List of jobs

    //Get list of jobs
    @GetMapping("/jobs")
    public List<Job> findAll(){ //this the endpoint we are creating here which return all the jobs
        return jobs;
    }

    //Create a new job
    @PostMapping("/jobs")
    public String CreateJob(@RequestBody Job job){
         //this the endpoint we are creating here which return all the jobs
        jobs.add(job);
        return "Job added successfully";
    }
}


