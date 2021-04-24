package com.db.test.config;

import java.util.Arrays;

public enum  WeekEnum {

    MON(1, "Monday"),
    TUE(2, "Tuesday"),
    WED(3, "Wednesday"),
    THU(4,"Thursday"),
    FRI(5, "Friday"),
    SAT(6, "Saturday"),
    SUN(0, "Sunday");

    WeekEnum(int id, String text) {
        this.id = id;
        this.text = text;
    }

    private int id;
    private String text;

    public static String getText(int inputNumber) {
        return Arrays.stream(WeekEnum.values()).filter(s -> s.id == inputNumber).findFirst().get().text;
    }
}
