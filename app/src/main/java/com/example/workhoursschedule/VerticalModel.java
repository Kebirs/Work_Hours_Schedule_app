package com.example.workhoursschedule;

public class VerticalModel {
    String  days_names;
    Integer days_position_number;

    public VerticalModel(Integer numbers, String names) {
        this.days_position_number = numbers;
        this.days_names = names;
    }

    public Integer getDaysNumber() {
        return days_position_number;
    }

    public String getDaysNames() {
        return days_names;
    }
}
