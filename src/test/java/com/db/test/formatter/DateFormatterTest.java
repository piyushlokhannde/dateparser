package com.db.test.formatter;

import com.db.test.config.NumberToText;
import com.db.test.parser.ParsedDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateFormatterTest {

    private NumberToText numberToText = new NumberToText();
    private DateFormatter dateFormatter = new DateFormatter(numberToText);
    private ParsedDate parsedDate = new ParsedDate.ParsedDateBuilder()
            .ofDay("21")
            .ofMonth("01")
            .ofYear("2021")
            .ofHour("06")
            .ofMinute("07")
            .ofSecond("10")
            .ofMeridian("AM")
            .build();




    @Test
    public void test_valid_date_format() {
        FormattedDate formattedDate = dateFormatter.format(parsedDate);
        assertEquals("21st-Jan-Twenty Twenty One", formattedDate.getValidDate());
    }

    @Test
    public void test_valid_time_format() {
        FormattedDate formattedDate = dateFormatter.format(parsedDate);
        assertEquals("Six Hours Seven Minutes Ten Seconds - Morning", formattedDate.getValidTime());
    }

    @Test
    public void test_valid_time_for_1_hour_1_min_1_sec_format() {
        ParsedDate parsedDate1 = new ParsedDate.ParsedDateBuilder()
                .ofDay("21")
                .ofMonth("01")
                .ofYear("2021")
                .ofHour("01")
                .ofMinute("01")
                .ofSecond("01")
                .ofMeridian("PM")
                .build();

        FormattedDate formattedDate = dateFormatter.format(parsedDate1);
        assertEquals("One Hour One Minute One Second - Evening", formattedDate.getValidTime());
    }


    @Test
    public void test_valid_day_of_the_week() {
        ParsedDate parsedDate1 = new ParsedDate.ParsedDateBuilder()
                .ofDay("21")
                .ofMonth("04")
                .ofYear("2021")
                .ofHour("01")
                .ofMinute("01")
                .ofSecond("01")
                .ofMeridian("PM")
                .build();
        FormattedDate formattedDate = dateFormatter.format(parsedDate1);
        assertEquals("Wednesday", formattedDate.getValidDayOfWeek());
    }
}
