package com.camunda.training.service;

import com.camunda.training.model.ProjectDetails;
import org.springframework.stereotype.Service;


public interface IProjectDetailsService {
   void saveProjectDetails(ProjectDetails projectDetails);

}
