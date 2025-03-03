package com.example.SpringBootRest.service;

import com.example.SpringBootRest.model.JobPost;
import com.example.SpringBootRest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
       return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Mobile Developer", "Develop mobile apps for Android and iOS", 1, Arrays.asList("Android", "iOS")),
                new JobPost(2, "C Developer", "Work on embedded systems and low-level programming", 0, Arrays.asList("Embedded", "Kernel", "System", "IOT")),
                new JobPost(3, "C++ Developer", "Develop high-performance applications for robotics and gaming", 4, Arrays.asList("Game", "Robotics", "Embedded")),
                new JobPost(4, ".Net Developer", "Build web and mobile applications using .NET", 2, Arrays.asList("WebApp", "Mobile"))
        ));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
            return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
