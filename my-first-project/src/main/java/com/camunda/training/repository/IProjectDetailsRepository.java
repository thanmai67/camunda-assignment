package com.camunda.training.repository;

import com.camunda.training.model.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectDetailsRepository extends JpaRepository<ProjectDetails,Integer> {

}
