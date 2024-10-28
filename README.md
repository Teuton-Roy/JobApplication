# Java Spring-Boot Project: Job Application

# Project Structure:
![image](https://github.com/user-attachments/assets/7a9a148b-ebba-4a36-9538-c1df0424d000)
![image](https://github.com/user-attachments/assets/cbe0d895-5e8f-4673-a839-4a4b4a6d2caa)

# Resquest mapping @annotation in springboot...

### *Request mapping is an @annotation that is provided to us and it can used  at method level as well as class level.  

## At method level we have different methods like...  

1. @GetMapping
2. @PostMapping
3. @PutMapping
4. @DeleteMapping
5. @PatchMapping

## At class level we have different methods like...  

#### *class level: it used to set a base URL for a perticular controller like my JobController.

1. @RestController
2. @RequestMapping : means when it's applied at class level it sets a base URL path for all the   methods that are handeling request in that particular controller. [exmaple: @ResquestMapping("/jobs")]


# List of end-points and API urls...  

### All the end-points I will be building...

* GET / jobs -> List of jobs
* GET /jobs/{id} -> get specific job by ID
* POST/ jobs -> Create a new job (request body should contain the job details)
* DELETE /jobs/{id} -> Delete a specific job by ID
* PUT /jobs/{id} -> Update a specific job by ID (request body should contain the updated job details)

  

### Examples API URLs...

* GET {base url}/ jobs
* GET {base url}/ jobs/1
* POST {base url}/ jobs
* DELETE {base url}/ jobs/1
* PUT {base url}/ jobs/1


# 23-10-2024 ==> Today's Task...

we have define an endpoints which gives us the list of jobs that exist in our application.  
Job --> JobController --> Job
1. GET / jobs -> List of jobs [GET {base url}/ jobs] --> Created

# 24-10-2024 ==> Today's Task...  

1. POST/ jobs -> Create a new job (request body should contain the job details) [POST {base url}/ jobs] --> created  
using JSONlint create job details..  
{  
    "id": 1,  
    "title": "Software Engineer 1",  
    "description": "Test Description",  
    "minSalary": "30000",  
    "maxSalary": "45000",  
    "location": "Gurgoan"  
}  

2. Created job_service interface for loss coupling.  
Because, have some modularity in my code-base, so I can separate the interface and the implementation. for that I created Implementation package and job_service_impl class.  


3. * Problem_1: When I created a Job without [job_id] it take  the parameter null in job, without a job_id it need to show output error or anything else....??

* Solution: 
1. Create a class variable called [nextId].  

2. This variable which used to keep track of job_id that I have in my application. And, it will do is, set current id to job object then it will increment by 1.
3. Also, this will help with no duplicate job_id in my job[every I create new job, job_id will be unique].


# 25-10-2024 ===> Today's Task...

1. GET /jobs/{id} -> get specific job by ID [GET {base url}/ jobs/1]---> created

use @PathVariable annotation which is used to extract the value from the URL.

Response entity: Response entity is class in spring and it's a wrapper that represent the entire HTTP response.


//Get specific job by ID using ResponseEntity for batter readability and HTTP response.  
    @GetMapping("/jobsById/{id}")  
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {  
        Job job = jobservice.getJobById(id);  
        if (job != null){  
            return new ResponseEntity<>(job, HttpStatus.OK);  
        }  
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
    }  


# 26-10-2024 ==> Today's Task...  

1. DELETE /jobs/{id} -> Delete a specific job by ID [DELETE {base url}/ jobs/1] --> Created 

2. PUT /jobs/{id} -> Update a specific job by ID [PUT {base url}/ jobs/1] --> Created


# 27-10-2024 ==> Today's Task...

## what is JPA?
    
    I have a Job class...  

    
    public class Job {
    private Long id; 
    private String company;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    }
    

    Now I need to store the job class into a database. How I do this??  
##    Using JPA [Java Persistence API]  

    It allows us to convert object into relational table.  
![Job class object to relational table](image-1.png)  

## Advantages of using JPA
    -> Easy and Simple.
    -> Makes writting query easier
    -> Allows us to save and update objects without using DML language at all.
    -> Easy integration with Spring-Boot.

## Enabling JPA by adding application properties...
        Spring.h2.console.enabled = true
        Spring.datasource.url = jdbc:h2:mem:test
    

# H2 database [using in my project]

## About:
    -> It's a Open Source relational database written in Java and it's fast for java based applications.
    -> It's an SQL database based on java.
    -> It has Embaded mode [means, runs same JVM within same application] while Server mode [means, it has running on it's own, it has accept connections from the clients over the network]

```Done with Job_Controller, Job_Service, Job_Repository.```

# 28-10-2024 ==> Today's Task...

    ```Start With Company```

    ![Company](image-2.png)

