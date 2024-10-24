package com.example.JobApplication.Job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class JobController {

    //Defining job controller here...

    private List<job> jobs= new ArrayList<>(); //List of jobs

    @GetMapping("/jobs")
    public List<job> findAll(){ //this the endpoint we are creating here which return all the jobs
        return jobs;
    }

}


