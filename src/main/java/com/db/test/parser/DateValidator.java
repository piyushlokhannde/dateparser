package com.db.test.parser;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeInlineAnnotationReader;

import static com.db.test.config.Constants.INVALID_MAX_DAYS_IN_MONTH_MSG;

public class DateValidator {

    public Boolean validateDate(ParsedDate parsedDate) throws InvalidDaysInMonth {
        validateMaximumNumberOfDaysInMonth(parsedDate);
        return Boolean.TRUE;
    }


    private void validateMaximumNumberOfDaysInMonth(ParsedDate parsedDate) throws InvalidDaysInMonth {

        Integer days = parsedDate.getDay();
        Integer month = parsedDate.getMonth();

        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                if(days > 30)
                    throw new InvalidDaysInMonth(INVALID_MAX_DAYS_IN_MONTH_MSG);
                break;
            case 2: {
                   if ((isLealYear(parsedDate.getYear()) && days > 29) ||
                           (!isLealYear(parsedDate.getYear()) && days > 28)) {
                       throw new InvalidDaysInMonth(INVALID_MAX_DAYS_IN_MONTH_MSG);
                   }
                }
                 break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(days > 32)
                    throw new InvalidDaysInMonth(INVALID_MAX_DAYS_IN_MONTH_MSG);
                break;

            default:
               throw new RuntimeException("Invalid Month Number");
        }



    }

    private boolean isLealYear(Integer year) {
        return (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0));
    }
}
