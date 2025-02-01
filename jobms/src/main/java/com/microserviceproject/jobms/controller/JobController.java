package com.microserviceproject.jobms.controller;

import com.microserviceproject.jobms.model.Job;
import com.microserviceproject.jobms.service.impl.JobServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/jobs")
public class JobController {
    private static final Log log = LogFactory.getLog(JobController.class);
    @Autowired
    JobServiceImpl jobService;

    @GetMapping("/")
    public ResponseEntity<List<Job>> getJob(){
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId){
        jobService.getJobById(jobId);
        return  null;
    }

    @PostMapping("/post")
    public ResponseEntity<Object>  postJob(@RequestBody Job jobPost){

        try{
            jobService.postJob(jobPost);
            return new ResponseEntity<>( "Job added Successfully",HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.info("Failed to post Job");
            return new ResponseEntity<>("Job Posting failed", HttpStatus.EXPECTATION_FAILED);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteJob(@PathVariable Long jobId){
        boolean deleted = jobService.deleteJobById(jobId);

        if(deleted){
            return  new ResponseEntity<>("Job deleted succsesfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Object> updateJobPost(@RequestBody Job updatedJob, @PathVariable Long jobId){
        boolean updated = jobService.updateJob(jobId, updatedJob);
        if(updated){
            return  new ResponseEntity<>("Job Post updated", HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
