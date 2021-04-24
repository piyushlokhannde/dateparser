package com.db.test.parser;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.db.test.config.Constants.INVALID_DATE_PATTERN_MSG;

public class StringDateParser {

    private final String inputDate;
    private static final Pattern VALID_DATE_PATTERN =
            Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(\\d{4}) " +
      "(0[0-9]|1[012]):(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]):(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9])" +
                    " (AM|PM)$");

    private ParsedDate parsedDate;

    private final Matcher matcher;

    private final DateValidator dateValidator;

    public StringDateParser(String inputDate, DateValidator dateValidator) {

        this.inputDate = inputDate;
        this.matcher =  VALID_DATE_PATTERN.matcher(inputDate);
        this.dateValidator = dateValidator;
    }

    public Boolean parse() throws InvalidDateFormat, InvalidDaysInMonth {
       if(matcher.matches()){

           this.parsedDate = new ParsedDate.ParsedDateBuilder()
                   .ofDay(matcher.group(1))
                   .ofMonth(matcher.group(2))
                   .ofYear(matcher.group(3))
                   .ofHour(matcher.group(4))
                   .ofMinute(matcher.group(5))
                   .ofSecond(matcher.group(6))
                   .ofMeridian(matcher.group(7))
                   .build();
           dateValidator.validateDate(this.parsedDate);

       } else  {
           throw new InvalidDateFormat(INVALID_DATE_PATTERN_MSG);
       }
       return Boolean.TRUE;
    }

    public Optional<ParsedDate> getParsedDate() {
        return Optional.of(this.parsedDate);
    }
}
