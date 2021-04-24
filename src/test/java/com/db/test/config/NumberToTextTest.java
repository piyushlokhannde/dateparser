package com.db.test.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberToTextTest {

    private  NumberToText numberToText = new NumberToText();

    @Test
    public  void test_convert_numeric_1_to_text() {
        String output = numberToText.convert(1);
        assertEquals("One", output);
    }

    @Test
    public  void test_convert_numeric_5_to_text() {
        String output = numberToText.convert(5);
        assertEquals("Five", output);
    }

    @Test
    public  void test_convert_numeric_10_to_text() {
        String output = numberToText.convert(10);
        assertEquals("Ten", output);
    }

    @Test
    public  void test_convert_numeric_11_to_text() {
        String output = numberToText.convert(11);
        assertEquals("Eleven", output);
    }

    @Test
    public  void test_convert_numeric_15_to_text() {
        String output = numberToText.convert(15);
        assertEquals("Fifteen", output);
    }

    @Test
    public  void test_convert_numeric_20_to_text() {
        String output = numberToText.convert(20);
        assertEquals("Twenty", output);
    }

    @Test
    public  void test_convert_numeric_21_to_text() {
        String output = numberToText.convert(21);
        assertEquals("Twenty One", output);
    }

    @Test
    public  void test_convert_numeric_44_to_text() {
        String output = numberToText.convert(44);
        assertEquals("Forty Four", output);
    }


    @Test
    public  void test_convert_numeric_55_to_text() {
        String output = numberToText.convert(55);
        assertEquals("Fifty Five", output);
    }

    @Test
    public  void test_convert_numeric_89_to_text() {
        String output = numberToText.convert(89);
        assertEquals("Eighty Nine", output);
    }

    @Test
    public  void test_convert_numeric_90_to_text() {
        String output = numberToText.convert(90);
        assertEquals("Ninety", output);
    }

    @Test
    public  void test_convert_numeric_99_to_text() {
        String output = numberToText.convert(99);
        assertEquals("Ninety Nine", output);
    }

    @Test
    public  void test_convert_numeric_2021_to_text() {
        String output = numberToText.convert(2021);
        assertEquals("Twenty Twenty One", output);
    }

    @Test
    public  void test_convert_numeric_2020_to_text() {
        String output = numberToText.convert(2020);
        assertEquals("Twenty Twenty", output);
    }

    @Test
    public  void test_convert_numeric_120_to_text() {
        String output = numberToText.convert(120);
        assertEquals("One Twenty", output);
    }

    @Test
    public  void test_convert_numeric_1168_to_text() {
        String output = numberToText.convert(1168);
        assertEquals("Eleven Sixty Eight", output);
    }

    @Test
    public  void test_convert_numeric_1947_to_text() {
        String output = numberToText.convert(1947);
        assertEquals("Nineteen Forty Seven", output);
    }

    @Test
    public  void test_convert_numeric_3041_to_text() {
        String output = numberToText.convert(3041);
        assertEquals("Thirty Forty One", output);
    }





}
