package com.microserviceproject.jobms.service;

import com.microserviceproject.jobms.model.Job;
import com.microserviceproject.jobms.repository.JobRepository;
import com.microserviceproject.jobms.service.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JobService  implements JobServiceImpl {
    @Autowired
    JobRepository jobRepository;


    public boolean isNotAllowed(){
        return false;
    }

    @Override
    public void postJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {

        Optional<Job> jobPost = jobRepository.findById(id);
        while(jobPost.isPresent()){
            Job job = jobPost.get();
               return job;
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long jobId) {
       try{
            jobRepository.deleteById(jobId);
            return true;
        } catch (Exception e) {
           return false;
       }
    }

    @Override
    public boolean updateJob(Long jobId, Job updatedJob) {
        Optional<Job> jobPost = jobRepository.findById(jobId);
        if(jobPost.isPresent()){
            Job job = jobPost.get();
            job.deepCopy(updatedJob);
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
