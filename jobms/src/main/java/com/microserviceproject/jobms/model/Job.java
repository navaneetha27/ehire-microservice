package com.microserviceproject.jobms.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Job {
    public Job(Long jobId, String jobRole, String orgName, String description, Double minSalary, Double maxSalary) {
        this.jobId = jobId;
        this.jobRole = jobRole;
        this.orgName = orgName;
        this.jobDescription = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    private String jobRole;
    private String orgName;
    private String jobDescription;
    private Double minSalary;
    private Double maxSalary;

    @ManyToOne
    private Company company;

    public Job() {

    }


    public void deepCopy(Job updatedJob) {
        this.setJobRole(updatedJob.getJobRole());
        this.setOrgName(updatedJob.getOrgName());
        this.setMinSalary(updatedJob.getMinSalary());
        this.setMaxSalary(updatedJob.getMaxSalary());
        this.setJobDescription(updatedJob.getJobDescription());
    }
}
