package com.db.test.parser;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static com.db.test.config.Constants.INVALID_DATE_PATTERN_MSG;
import static com.db.test.config.Constants.INVALID_MAX_DAYS_IN_MONTH_MSG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringDateParserTest {


    private DateValidator dateValidator = new DateValidator();


    @ParameterizedTest
    @ValueSource(strings = {"00-01-2021 06:07:10 AM", "32-01-2021 06:07:10 AM",
            "1-01-2021 06:07:10 AM",  "1.1-01-2021 06:07:10 AM", "1a-01-2021 06:07:10 AM",
            "bb-01-2021 06:07:10 AM", "??-01-2021 06:07:10 AM",  "()-01-2021 06:07:10 AM",
            "-01-2021 06:07:10 AM"})
    public void testValidate_for_invalid_date_input(String inputDate) {

        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Exception exception = assertThrows(InvalidDateFormat.class, () -> {
            stringDateParser.parse();
        });
        assertEquals(INVALID_DATE_PATTERN_MSG, exception.getMessage());
    }


    @ParameterizedTest
    @ValueSource(strings = {"01-01-2021 06:07:10 AM", "05-01-2021 06:07:10 AM", "10-01-2021 06:07:10 AM",
            "11-01-2021 06:07:10 AM", "15-01-2021 06:07:10 AM", "20-01-2021 06:07:10 AM",
            "21-01-2021 06:07:10 AM", "25-01-2021 06:07:10 AM", "29-01-2021 06:07:10 AM",
            "30-01-2021 06:07:10 AM", "31-01-2021 06:07:10 AM"})
    public void testValidate_for_valid_date_input(String inputDate) throws InvalidDateFormat, InvalidDaysInMonth {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Boolean isValid = stringDateParser.parse();
        assertEquals(Boolean.TRUE, isValid);
    }

    @ParameterizedTest
    @ValueSource(strings = {"01-00-2021 06:07:10 AM", "05-13-2021 06:07:10 AM", "10- -2021 06:07:10 AM",
            "11--2021 06:07:10 AM", "15-**-2021 06:07:10 AM", "15-5-2021 06:07:10 AM",
            "01-dd-2021 06:07:10 AM"})
    public void testValidate_for_invalid_month_input(String inputDate) {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Exception exception = assertThrows(InvalidDateFormat.class, () -> {
            stringDateParser.parse();
        });
        assertEquals(INVALID_DATE_PATTERN_MSG, exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"01-01-2021 06:07:10 AM", "01-12-2021 06:07:10 AM", "01-05-2021 06:07:10 AM"})
    public void testValidate_for_valid_month_input(String inputDate) throws InvalidDateFormat, InvalidDaysInMonth {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Boolean isValid = stringDateParser.parse();
        assertEquals(Boolean.TRUE, isValid);
    }

    @ParameterizedTest
    @ValueSource(strings = {"01-01-0001 06:07:10 AM", "01-01-0201 06:07:10 AM", "01-01-1201 06:07:10 AM",
            "01-01-2201 06:07:10 AM",  "01-01-2121 06:07:10 AM", "01-01-2500 06:07:10 AM",
            "01-01-0000 06:07:10 AM"})
    public void testValidate_for_valid_year_input(String inputDate) throws InvalidDateFormat, InvalidDaysInMonth {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Boolean isValid = stringDateParser.parse();
        assertEquals(Boolean.TRUE, isValid);
    }


    @ParameterizedTest
    @ValueSource(strings = {"01-01- 06:07:10 AM", "01-01-asaaa 06:07:10 AM", "01-01-12 06:07:10 AM",
            "01-01-12er 06:07:10 AM", "01-01-?$@W 06:07:10 AM"})
    public void testValidate_for_invalid_year_input(String inputDate) throws InvalidDateFormat {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Exception exception = assertThrows(InvalidDateFormat.class, () -> {
            stringDateParser.parse();
        });
        assertEquals(INVALID_DATE_PATTERN_MSG, exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"01-01-2021 13:07:10 AM", "01-01-2021 :07:10 AM" , "01-01-2021 aa:07:10 AM"})
    public void testValidate_for_invalid_hour_input(String inputDate) throws InvalidDateFormat {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Exception exception = assertThrows(InvalidDateFormat.class, () -> {
            stringDateParser.parse();
        });
        assertEquals(INVALID_DATE_PATTERN_MSG, exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"01-01-0001 00:07:10 AM", "01-01-0001 01:07:10 AM", "01-03-0001 09:07:10 AM",
            "01-03-0001 10:07:10 AM",  "01-03-0001 11:07:10 AM",  "01-03-0001 12:07:10 AM"})
    public void testValidate_for_valid_hour_input(String inputDate) throws InvalidDateFormat, InvalidDaysInMonth {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Boolean isValid = stringDateParser.parse();
        assertEquals(Boolean.TRUE, isValid);
    }

    @ParameterizedTest
    @ValueSource(strings = {"01-01-0001 00:60:10 AM", "01-01-0001 00::10 AM", "01-01-0001 00:aa:10 AM",
            "01-01-0001 00:62:10 AM", "01-01-0001 00:100:10 AM"})
    public void testValidate_for_invalid_minute_input(String inputDate) throws InvalidDateFormat {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Exception exception = assertThrows(InvalidDateFormat.class, () -> {
            stringDateParser.parse();
        });
        assertEquals(INVALID_DATE_PATTERN_MSG, exception.getMessage());
    }


    @ParameterizedTest
    @ValueSource(strings = {"01-01-0001 00:00:10 AM", "01-01-0001 00:01:10 AM", "01-01-0001 00:10:10 AM",
            "01-01-0001 00:11:10 AM", "01-01-0001 00:20:10 AM", "01-01-0001 00:30:10 AM", "01-01-0001 00:40:10 AM",
            "01-01-0001 00:41:10 AM", "01-01-0001 00:49:10 AM", "01-01-0001 00:50:10 AM","01-01-0001 00:59:10 AM"})
    public void testValidate_for_valid_minute_input(String inputDate) throws InvalidDateFormat, InvalidDaysInMonth {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Boolean isValid = stringDateParser.parse();
        assertEquals(Boolean.TRUE, isValid);
    }


    @ParameterizedTest
    @ValueSource(strings = {"01-01-0001 00:00:60 AM", "01-01-0001 00:00: AM", "01-01-0001 00:00:aa AM",
            "01-01-0001 00:00:62 AM", "01-01-0001 00:00:100 AM"})
    public void testValidate_for_invalid_seconds_input(String inputDate) throws InvalidDateFormat {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Exception exception = assertThrows(InvalidDateFormat.class, () -> {
            stringDateParser.parse();
        });
        assertEquals(INVALID_DATE_PATTERN_MSG, exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"01-01-0001 00:00:00 AM", "01-01-0001 00:00:01 AM", "01-01-0001 00:00:10 AM",
            "01-01-0001 00:10:11 AM", "01-01-0001 00:10:20 AM", "01-01-0001 00:10:30 AM", "01-01-0001 00:10:40 AM",
            "01-01-0001 00:10:41 AM", "01-01-0001 00:10:49 AM", "01-01-0001 00:10:50 AM","01-01-0001 00:10:59 AM"})
    public void testValidate_for_valid_seconds_input(String inputDate) throws InvalidDateFormat, InvalidDaysInMonth {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Boolean isValid = stringDateParser.parse();
        assertEquals(Boolean.TRUE, isValid);
    }

    @ParameterizedTest
    @ValueSource(strings = {"01-01-0001 00:10:50 ", "01-01-0001 00:10:50 am", "01-01-0001 00:10:50 pm",
            "01-01-0001 00:10:50 @@", "01-01-0001 00:10:50 11"})
    public void testValidate_for_invalid_Meridian_input(String inputDate) throws InvalidDateFormat {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Exception exception = assertThrows(InvalidDateFormat.class, () -> {
            stringDateParser.parse();
        });
        assertEquals(INVALID_DATE_PATTERN_MSG, exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"01-01-0001 00:00:00 AM" , "01-01-0001 00:00:00 PM" })
    public void testValidate_for_valid_Meridian_input(String inputDate) throws InvalidDateFormat, InvalidDaysInMonth {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Boolean isValid = stringDateParser.parse();
        assertEquals(Boolean.TRUE, isValid);
    }

    @Test
    public void testParsedDateValues() throws InvalidDateFormat, InvalidDaysInMonth {
        String inputDateString  = "01-11-2021 05:54:12 AM";
        StringDateParser stringDateParser = new StringDateParser(inputDateString, dateValidator);
        stringDateParser.parse();
        Optional<ParsedDate> parsedDateObect = stringDateParser.getParsedDate();
        ParsedDate parsedDate = parsedDateObect.get();
        assertEquals(parsedDate.getDay(), 1);
        assertEquals(parsedDate.getMonth(), 11);
        assertEquals(parsedDate.getYear(), 2021);
        assertEquals(parsedDate.getHour(), 5);
        assertEquals(parsedDate.getMinute(), 54);
        assertEquals(parsedDate.getSecond(), 12);
        assertEquals(parsedDate.getMeridian(), "AM");

    }

    @ParameterizedTest
    @ValueSource(strings = {"31-04-2021 00:00:00 AM" , "31-06-2021 00:00:00 AM" , "31-09-2021 00:00:00 AM",
            "31-11-2021 00:00:00 AM", "29-02-2021 00:00:00 AM"})
    public void testInvalid_Number_Of_days_for_odd_month(String inputDate) throws InvalidDateFormat , InvalidDaysInMonth {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Exception exception = assertThrows(InvalidDaysInMonth.class, () -> {
            stringDateParser.parse();
        });
        assertEquals(INVALID_MAX_DAYS_IN_MONTH_MSG, exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"31-01-2021 00:00:00 AM" , "31-03-2021 00:00:00 AM" , "31-05-2021 00:00:00 AM",
            "31-07-2021 00:00:00 AM", "31-08-2021 00:00:00 AM", "31-10-2021 00:00:00 AM", "31-12-2021 00:00:00 AM"})
    public void testInvalid_Number_of_days_even_days(String inputDate) throws InvalidDateFormat , InvalidDaysInMonth {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Boolean isValid = stringDateParser.parse();
        assertEquals(Boolean.TRUE, isValid);
    }

    @ParameterizedTest
    @ValueSource(strings = {"28-02-2021 00:00:00 AM" , "29-02-2020 00:00:00 AM"})
    public void test_valid_max_number_of_days_for_feb(String inputDate) throws InvalidDateFormat, InvalidDaysInMonth {
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        Boolean isValid = stringDateParser.parse();
        assertEquals(Boolean.TRUE, isValid);
    }

}
