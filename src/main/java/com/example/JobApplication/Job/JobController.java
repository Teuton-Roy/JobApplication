package com.example.JobApplication.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class JobController {

    //Defining job controller here...

//    private List<Job> jobs= new ArrayList<>(); //List of jobs

    private final JobService jobservice;  //job_service will be available at runtime, and inject it to job_controller

    //constructor
    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    //Get list of all jobs
    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){ //this the endpoint we are creating here which return all the jobs
        return ResponseEntity.ok(jobservice.findall());
    }

    //Create a new job
    @PostMapping("/create_jobs")
    public ResponseEntity<String> CreateJob(@RequestBody Job job){
         //this the endpoint we are creating here which return all the jobs
        jobservice.createJob(job);
        return new ResponseEntity<>("Job Added Successfully", HttpStatus.OK);
    }

    //Get specific job by ID
//    @GetMapping("/jobsById/{id}") // {} -> dynamic, id -> variable name
//    public Job getJobById(@PathVariable Long id) {
//
//        //public Job, why? Because fetching a particular job, this will return a Job Object.
//        //@PathVariable ->  this is used to extract the value from the URL.
//
//        Job job = jobservice.getJobById(id);
//
//        //add validation, if given id is not present then show this dummy job
//        if (job != null){
//            return job;
//        }
//        return new Job(0L,
//                "dummy job",
//                "Their no job associated with this id",
//                "000",
//                "000",
//                "India"
//        );
//    }

    //Get specific job by ID using ResponseEntity for batter readability and HTTP response
    @GetMapping("/jobsById/{id}") // {} -> dynamic, id -> variable name
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobservice.getJobById(id);
        if (job != null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


