package com.example.JobApplication.company;
import com.example.JobApplication.Job.Job;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Company {

    //Defining Company entity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    //map every company to list of jobs
    @OneToMany(mappedBy = "company") //this indicates that one company has many jobs opening
    /* @OneToMany(mappedBy = "company") this tells is this particular relationship that exist company to that of job is
    * mapped by a field called company which exist in JOB*/
    private List<Job> jobs;


    //private List<Review> reviews; later on...


    //Constructor
    public Company() {

    }

    //Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
