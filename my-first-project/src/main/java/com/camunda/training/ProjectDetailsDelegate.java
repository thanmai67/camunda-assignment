package com.camunda.training;

import com.camunda.training.model.ProjectDetails;
import com.camunda.training.service.IProjectDetailsService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectDetailsDelegate implements JavaDelegate {
    private final Logger LOGGER = LoggerFactory.getLogger(ProjectDetailsDelegate.class.getName());

    @Autowired
    private IProjectDetailsService iProjectDetailsService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
      System.out.println("Im in Java code");
      LOGGER.info("getting values from processor");
      String projectName = (String) execution.getVariable("projectName");
      String projectType = (String) execution.getVariable("projectType");
      //String projectName = (String) execution.getVariable("agentName" ,"companyName","projectName","projectType","originalLanguage");
        System.out.println("Im in ProjectDetails Delegate class");

        System.out.println(projectName);
      System.out.println(projectType);
      ProjectDetails projectDetails =new ProjectDetails(projectName);
      LOGGER.info("storing data to the database");
      iProjectDetailsService.saveProjectDetails(projectDetails);

    }
}
