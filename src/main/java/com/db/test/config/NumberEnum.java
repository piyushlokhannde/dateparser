package com.db.test.config;

import java.util.Arrays;

public enum NumberEnum {
    ZERO(0, ""),
    ONE(1, "One"),
    TWO(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    SIX(6, "Six"),
    SEVEN(7, "Seven"),
    EIGHT(8, "Eight"),
    NINE(9, "Nine"),
    TEN(10, "Ten"),
    ELEVEN(11, "Eleven"),
    TWELVE(12, "Twelve"),

    THIRTEEN(13, "Thirteen"),
    FOURTEEN(14, "Fourteen"),
    FIFTEEN(15, "Fifteen"),
    SIXTEEN(16, "Sixteen"),
    SEVENTEEN(17, "Seventeen"),
    EIGHTEEN(18, "Eighteen"),
    NINETEEN(19, "Nineteen"),
    TWENTY(20, "Twenty"),
    THIRTY(30, "Thirty"),
    FORTY(40, "Forty"),
    FIFTY(50, "Fifty"),
    SIXTY(60, "Sixty"),
    SEVENTY(70, "Seventy"),
    EIGHTY(80, "Eighty"),
    NINETY(90, "Ninety");


    NumberEnum(int number, String text) {
        this.number = number;
        this.text = text;

    }

    private int number;
    private String text;

     public static String getText(int inputNumber) {
      return Arrays.stream(NumberEnum.values()).filter(s -> s.number == inputNumber).findFirst().get().text;
    }
}
