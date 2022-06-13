package com.camunda.training;

import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.extension.process_test_coverage.junit5.ProcessEngineCoverageExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ProcessEngineCoverageExtension.class)
public class ProcessJUnitTest {
  
  @Test
  @Deployment(resources = "process.bpmn")
  public void testHappyPath() {
//    // Create a HashMap to put in variables for the process instance
//    Map<String, Object> variables = new HashMap<String, Object>();
//    variables.put("content", "Exercise 4 test - Thanmai");
//    // Start process with Java API and variables
//    ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("TwitterReviewProcess", variables);
//
//    // Make assertions on the process instance
//    assertThat(processInstance).isEnded();
  }
}


