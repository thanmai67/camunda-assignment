package com.camunda.training.delegates;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.impl.context.Context;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.impl.context.Context;

public class TaskAssignmentListener implements TaskListener {

    private static final String HOST = "smtp.gmail.com";
    private static final String USER = "thanmai.cam.67@gmail.com";
    private static final String PWD = "Monika@67";
    private final static Logger LOGGER = Logger.getLogger(TaskAssignmentListener.class.getName());

//    @Override
   public void notify(DelegateTask delegateTask) {

        String assignee = delegateTask.getAssignee();
        String taskId = delegateTask.getId();
        LOGGER.info("Task assigned to :"+assignee);

        if (assignee != null) {

        }
       // Get User Profile from User Management
       IdentityService identityService = Context.getProcessEngineConfiguration().getIdentityService();
       User user = identityService.createUserQuery().userId(assignee).singleResult();


       if (user != null) {

           // Get Email Address from User Profile
           String recipient = user.getEmail();

           if (recipient != null && !recipient.isEmpty()) {

               Email email = new SimpleEmail();
               email.setHostName(HOST);
               email.setAuthentication(USER, PWD);

               try {
                   email.setFrom("noreply@camunda.org");
                   email.setSubject("Task assigned: " + delegateTask.getName());
                   email.setMsg("Please complete: https://localhost:8080/camunda/app/tasklist/default/#/task/" + taskId);


                   email.addTo(recipient);


                   email.send();
                   LOGGER.info("Task Assignment Email successfully sent to user ???" + assignee + "??? with address ???" + recipient + "???.");

               } catch (Exception e) {
                   LOGGER.log(Level.WARNING, "Could not send email to assignee", e);
               }

           } else {
               LOGGER.warning("Not sending email to user " + assignee + "???, user has no email address.");
           }

       } else {
           LOGGER.warning("Not sending email to user " + assignee + "???, user is not enrolled with identity service.");
       }

   }

}


