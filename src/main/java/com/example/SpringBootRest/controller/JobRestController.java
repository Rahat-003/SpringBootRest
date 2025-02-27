package com.example.SpringBootRest.controller;


import com.example.SpringBootRest.model.JobPost;
import com.example.SpringBootRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobposts")
    @ResponseBody
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }
}
