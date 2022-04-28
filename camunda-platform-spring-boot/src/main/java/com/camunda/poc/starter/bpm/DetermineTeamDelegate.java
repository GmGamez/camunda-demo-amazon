package com.camunda.poc.starter.bpm;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jayway.jsonpath.internal.function.text.Concatenate;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.feel.syntaxtree.If;
import org.springframework.stereotype.Component;

/**
 * This is an easy adapter implementation
 * illustrating how a Java Delegate can be used
 * from within a BPMN 2.0 Service Task.
 */
@Component("DetermineTeamDelegate")
public class DetermineTeamDelegate implements JavaDelegate {


    public void execute(DelegateExecution execution) throws Exception {

        String category = (String) execution.getVariable("teamCategory");
        String utilization = (String) execution.getVariable("teamUtilization");
        System.out.println("Category is: " + category);
        System.out.println("Utilization value is: " + utilization);

        if (utilization.equals("Low")) {
            execution.setVariable("teamName", category.concat(" Team 1"));
            System.out.println("Team name is: " + category.concat(" Team 1"));
                }
        else if (utilization.equals("Medium")){
            execution.setVariable("teamName", category.concat(" Team 2"));
            System.out.println("Team name is: " + category.concat(" Team 2"));
        }
        else if (utilization.equals("High")){
            execution.setVariable("teamName", category.concat(" Team 3"));
            System.out.println("Team name is: " + category.concat(" Team 3"));
        }
        else if (utilization.equals("Any")){
            execution.setVariable("teamName", category.concat(" Team 4"));
            System.out.println("Team name is: " + category.concat(" Team 4"));
        }
    }
}
