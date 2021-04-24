package com.db.test;

import com.db.test.config.NumberToText;
import com.db.test.formatter.DateFormatter;
import com.db.test.formatter.FormattedDate;
import com.db.test.parser.*;

import java.util.Optional;
import java.util.Scanner;

public class DateParser {

    public static void main(String[] args) {
        DateParser dateParser = new DateParser();
        dateParser.parseUtil();

    }

    private void parseUtil() {

        String inputDate = enterInput();
        try {
            Optional<ParsedDate> parsedDateOptional =  parseDate(inputDate);
            if(parsedDateOptional.isPresent()) {
                ParsedDate parsedDate = parsedDateOptional.get();
                FormattedDate formattedDate = formatDate(parsedDate);
                printOutput(formattedDate);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private String enterInput() {
        System.out.println("Enter the date to be parse");
        Scanner in = new Scanner(System.in);
        String inputDate = in.nextLine();
        return inputDate;
    }

    private Optional<ParsedDate> parseDate(String inputDate) throws InvalidDateFormat, InvalidDaysInMonth {
        Optional<ParsedDate> parsedDate = null;
        DateValidator dateValidator = new DateValidator();
        StringDateParser stringDateParser = new StringDateParser(inputDate, dateValidator);
        stringDateParser.parse();
        if(stringDateParser.parse()) {
           parsedDate = stringDateParser.getParsedDate();
        } else {
            new RuntimeException("Not able to parse the date");
        }
        return parsedDate;
    }

    private FormattedDate formatDate(ParsedDate parsedDate) {
        NumberToText numberToText = new NumberToText();
        DateFormatter dateFormatter = new DateFormatter(numberToText);
        FormattedDate formattedDate = dateFormatter.format(parsedDate);
        return formattedDate;
    }

    private void printOutput(FormattedDate formattedDate) {
        System.out.println("Valid Date : "+formattedDate.getValidDate());
        System.out.println("Valid Time : "+formattedDate.getValidTime());
        System.out.println("Day of week: "+formattedDate.getValidDayOfWeek());

    }


}
