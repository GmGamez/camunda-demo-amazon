package com.camunda.poc.starter.bpm;

import java.util.ArrayList;
import java.util.List;

public class teamList {

    public teamList(String curriculum_development, String s, int i) {
    }

    public static class teams {
        String category = null;
        String name = null;
        Integer utilization = null;

        teams(String category, String name, Integer utilization) {
            this.category = category;
            this.name = name;
            this.utilization = utilization;
        }
    }

    public static void main() {

        List<teamList> myLists = new ArrayList<>();
        myLists.add(new teamList("Curriculum Development", "Team Curriculum Development-A", 40));
        myLists.add(new teamList("Curriculum Development", "Team Curriculum Development-B", 90));
        myLists.add(new teamList("Curriculum Development", "Team Curriculum Development-C", 10));
        myLists.add(new teamList("Curation", "Team Curation-A", 10));
        myLists.add(new teamList("Curation", "Team Curation-B", 50));
        myLists.add(new teamList("Curation", "Team Curation-C", 90));
        myLists.add(new teamList("Guided Publishing", "Team Guided Publishing-A", 10));
        myLists.add(new teamList("Guided Publishing", "Team Guided Publishing-B", 40));
        myLists.add(new teamList("Guided Publishing", "Team Guided Publishing-C", 85));
    }
}