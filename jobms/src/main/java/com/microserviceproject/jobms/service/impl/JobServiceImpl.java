package com.microserviceproject.jobms.service.impl;


import com.microserviceproject.jobms.model.Job;

import java.util.List;

public interface JobServiceImpl {
    public  void postJob(Job job);
    public List<Job> getAllJobs();
    public Job getJobById(Long id);

    boolean deleteJobById(Long jobId);

    boolean updateJob(Long jobId, Job updatedJob);
}
