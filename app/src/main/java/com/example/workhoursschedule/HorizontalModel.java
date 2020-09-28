package com.example.workhoursschedule;

public class HorizontalModel {
    String month_names;
    Integer months_position_number;


    public HorizontalModel(Integer numbers, String names) {
        this.months_position_number = numbers;
        this.month_names = names;
    }

    public Integer getMonthsNumber() {
        return months_position_number;
    }

    public String getMonthNames() {
        return month_names;
    }
}
