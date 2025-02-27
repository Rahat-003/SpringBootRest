package com.example.SpringBootRest.repo;

import com.example.SpringBootRest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {
    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java", "Exp: 2", 1),
            new JobPost(2, "C", "Exp: 2", 0),
            new JobPost(1, "C++", "Exp: 3",4),
            new JobPost(2, ".Net", "Exp: 1",2)
    ));

    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public void addJob(JobPost job) {
        jobs.add(job);
        System.out.println("Job added: " + job);
    }

}
