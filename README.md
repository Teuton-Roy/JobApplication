# Java Spring-Boot Project: Job Application

# Project Structure:
![image](https://github.com/user-attachments/assets/7a9a148b-ebba-4a36-9538-c1df0424d000)
![image](https://github.com/user-attachments/assets/cbe0d895-5e8f-4673-a839-4a4b4a6d2caa)


# List of end-points and API urls...  

* All the end-points I will be building...
* GET / jobs -> List of jobs
* GET /jobs/{id} -> get specific job by ID
* POST/ jobs -> Create a new job (request body should contain the job details)
* DELETE /jobs/{id} -> Delete a specific job by ID
* PUT /jobs/{id} -> Update a specific job by ID (request body should contain the updated job details)
* GET/ jobs/{id}/company -> Get the company details for a specific job by ID
  

* Examples API URLs...
* GET {base url}/ jobs
* GET {base url}/ jobs/1
* POST {base url}/ jobs
* DELETE {base url}/ jobs/1
* PUT {base url}/ jobs/1
* GET {base url}/ jobs/1/company

# 23-10-2024 ==> Today's Task...

we have define an endpoints which gives us the list of jobs that exist in our application.  
Job --> JobController --> Job
1. GET / jobs -> List of jobs [GET {base url}/ jobs] --> Created

# 24-10-2024 ==> Today's Task...  

