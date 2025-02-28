package com.example.SpringBootRest.repo;

import com.example.SpringBootRest.model.JobPost;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {
    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Mobile Developer", "Exp: 2", 1, Arrays.asList("Android", "iOS")),
            new JobPost(2, "C", "Exp: 2", 0, Arrays.asList("Embedded", "Kernel", "System", "IOT")),
            new JobPost(3, "C++", "Exp: 3",4, Arrays.asList("Game", "Robotics", "Embedded")),
            new JobPost(4, ".Net", "Exp: 1",2, Arrays.asList("WebApp", "Mobile"))
    ));

    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public void addJob(JobPost job) {
        jobs.add(job);
        System.out.println("Job added: " + job);
    }

    public JobPost getJob(int postId) {
        for (JobPost job: jobs) {
            if (job.getPostId() == postId)
                return job;
         }
        return null;
    }

}
