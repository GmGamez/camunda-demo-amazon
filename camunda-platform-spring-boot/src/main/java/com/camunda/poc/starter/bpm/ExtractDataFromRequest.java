package com.camunda.poc.starter.bpm;


import camundajar.impl.com.google.gson.JsonObject;
import org.camunda.bpm.*;
import com.jayway.jsonpath.internal.function.text.Concatenate;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.json.SpinJsonNode;
import org.springframework.stereotype.Component;
import static org.camunda.spin.Spin.*;

import java.util.logging.Logger;


/**
 * This is an easy adapter implementation 
 * illustrating how a Java Delegate can be used 
 * from within a BPMN 2.0 Service Task.
 */
@Component("ExtractDataFromRequest")
public class ExtractDataFromRequest implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(ExtractDataFromRequest.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {

    LOGGER.info("\n\n  ... BPMNErrorDelegate invoked by "
            + "processDefinitionId=" + execution.getProcessDefinitionId()
            + ", activtyId=" + execution.getCurrentActivityId()
            + ", activtyName='" + execution.getCurrentActivityName() + "'"
            + ", processInstanceId=" + execution.getProcessInstanceId()
            + ", businessKey=" + execution.getProcessBusinessKey()
            + ", executionId=" + execution.getId()
            + " \n\n");

    if (execution.hasVariable("request")) {
      SpinJsonNode request = JSON(execution.getVariable("request"));
      String domainProperty = request.prop("domain").stringValue();
      String requestingTeamProperty = request.prop("requestingTeam").stringValue();
      String descriptionProperty = request.prop("description").stringValue();
      String audienceProperty = request.prop("audience").stringValue();
      String modalityProperty = request.prop("modality").stringValue();
      String durationProperty = request.prop("duration").stringValue();
      String contentAvailableProperty = request.prop("contentAvailable").stringValue();
      String reasonProperty = request.prop("reason").stringValue();
      String smeAvailabilityProperty = request.prop("smeAvailability").stringValue();
      String requestIDProperty = request.prop("requestID").stringValue();


      double contentAvailableString = Double.parseDouble(contentAvailableProperty);
      int durationString = Integer.parseInt(durationProperty);

      execution.setVariable("domain", domainProperty);
      execution.setVariable("requestingTeam", requestingTeamProperty);
      execution.setVariable("requestID", requestIDProperty);
      execution.setVariable("audience", audienceProperty);
      execution.setVariable("modality", modalityProperty);
      execution.setVariable("duration", durationProperty);
      execution.setVariable("contentAvailable", contentAvailableProperty);
      execution.setVariable("reason", reasonProperty);
      execution.setVariable("smeAvailability", smeAvailabilityProperty);
    }

    if (execution.hasVariable("updates")) {
      String update = (String) execution.getVariable("updates");
      String description = (String) execution.getVariable("description");
      String updatedDescription = description.concat(". UPDATE: " + update);
      execution.setVariable("description", updatedDescription);
    }
  }
}
