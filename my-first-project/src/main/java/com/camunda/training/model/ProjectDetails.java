package com.camunda.training.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectDetails {
    @Id
    @GeneratedValue(generator = "project_sequence", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "project_sequence", sequenceName = "project_sequence", allocationSize = 1)
    private Integer projectId;
//    private String agentName;
//    private String companyName;
    private String projectName;
//    private String projectType;
//    private String originalLanguage;


    public ProjectDetails(String projectName) {
        this.projectName = projectName;
    }
}
