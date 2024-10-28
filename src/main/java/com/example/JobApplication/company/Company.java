package com.example.JobApplication.company;
import com.example.JobApplication.Job.Job;
import jakarta.persistence   .*;
import java.util.List;

@Entity
public class Company {

    //Defining Company entity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    //Constructor
    public Company() {

    }

    //map every company to list of jobs
    @OneToMany //this indicates that one company has many jobs opening
    private List<Job> jobs;
    //private List<Review> reviews; later on...

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
}
