package com.example.JobApplication.Job;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity                       //This @annotation tells Spring-Boot and JPA that this is the class this supposed to be mapped to a table.
@Table(name ="Job_Table")     //Instead of having same name as class name this @Table annotation change the table name.
public class Job {

    //Need to define what we need in this class, and what all info we need about the job...


    //fields for every jobs
    private Long id; //unique id for each job
    private String company;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;




    //constructor
    public Job(Long id, String title, String description, String minSalary, String maxSalary, String location, String company){
        this.id = id;
        this.company = company;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    //Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
