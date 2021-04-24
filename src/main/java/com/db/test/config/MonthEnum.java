package com.db.test.config;

import java.util.Arrays;

public enum MonthEnum {

    JAN(1, "Jan"),
    FEB(2, "Feb"),
    MAR(3, "Mar"),
    APR(4, "Apr"),
    MAY(5, "May"),
    JUN(6, "Jun"),
    JUL(7, "Jul"),
    AUG(8, "Aug"),
    SEP(9, "Sep"),
    OCT(10, "Oct"),
    NOV(11, "Nov"),
    DEC(12 ,"Dec");

    MonthEnum(int id, String description) {
        this.monthId = id;
        this.description = description;
    }

    private int monthId;
    private String description;

    public static String getText(int id) {
        return Arrays.stream(MonthEnum.values()).filter(s -> s.monthId == id).findFirst().get().description;
    }
}
