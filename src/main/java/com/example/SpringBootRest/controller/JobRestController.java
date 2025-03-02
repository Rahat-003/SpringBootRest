package com.example.SpringBootRest.controller;


import com.example.SpringBootRest.model.JobPost;
import com.example.SpringBootRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobposts")
    @ResponseBody
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("jobposts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        System.out.println("\n\nkeyword: " + keyword);
        return service.search(keyword);
    }

    @GetMapping("jobpost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @PostMapping("jobpost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("update")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("delete/{postId}")
    public void deleteJob(@PathVariable("postId") int postId) {
        service.deleteJob(postId);
    }

    @PostMapping("load")
    public String loadData() {
        service.load();
        return "success";
    }

}
