package com.camunda.training.service;

import com.camunda.training.model.ProjectDetails;
import com.camunda.training.repository.IProjectDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectDetailsServiceImpl implements IProjectDetailsService{
    @Autowired
     private IProjectDetailsRepository iProjectDetailsRepository;

    @Override
    public void saveProjectDetails(ProjectDetails projectDetails) {
        System.out.println(projectDetails);
        iProjectDetailsRepository.save(projectDetails);
    }
}
