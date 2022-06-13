package com.camunda.training;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AudioPostProductionDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String  AudioLanguage = (String) execution.getVariable("audioLanguage");
        String  DueDate= (String) execution.getVariable("dueDate");
        System.out.println("Im in AudioPostProduction Class");
        System.out.println(AudioLanguage);
        System.out.println(DueDate);

    }
}
