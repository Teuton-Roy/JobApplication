package com.example.JobApplication.Job;

import java.util.*;
public class JobController {

    //Defining job controller here...

    private List<job> jobs= new ArrayList<>(); //List of jobs
    public List<job> findAll(){ //this the endpoint we are creating here which return all the jobs
        return jobs;
    }

}
