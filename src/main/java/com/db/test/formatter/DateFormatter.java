package com.db.test.formatter;

import com.db.test.config.MonthEnum;
import com.db.test.config.NumberToText;
import com.db.test.config.WeekEnum;
import com.db.test.parser.ParsedDate;

import java.util.Date;

public class DateFormatter {

    private NumberToText numberToText;

    public DateFormatter(NumberToText numberToText) {
        this.numberToText = numberToText;
    }


    public FormattedDate format(ParsedDate parsedDate) {
        FormattedDate formattedDate = new FormattedDate();

        String dayFormat = parsedDate.getDay()
                + getDaySuffix(parsedDate.getDay())
                + "-"
                + MonthEnum.getText(parsedDate.getMonth())
                + "-"
                + this.numberToText.convert(parsedDate.getYear());
        formattedDate.setValidDate(dayFormat);


        String timeFormat = getHourFormat(parsedDate.getHour())
                + " "
                + getMinuteFormat(parsedDate.getMinute())
                + " "
                + getSecondFormat(parsedDate.getSecond())
                + " - "
                + getMeridiemText(parsedDate.getMeridian());

        formattedDate.setValidTime(timeFormat);

        formattedDate.setValidDayOfWeek(getDayOfWeek(parsedDate));
        return formattedDate;
    }


    private String getDayOfWeek(ParsedDate parsedDate) {
       Date date =  new Date(parsedDate.getYear()-1900, parsedDate.getMonth()-1, parsedDate.getDay());
       int day = date.getDay();
       return WeekEnum.getText(day);
    }

    private String getDaySuffix(int day) {
        if (day == 1 || day == 21) {
            return "st";
        } else if (day == 2 || day == 22) {
            return "nd";
        } else if (day == 3 || day == 23) {
            return "rd";
        } else {
            return "th";
        }
    }


    private String getHourFormat(int hour) {
        if (hour == 1) {
            return numberToText.convert(hour) + " " + "Hour";
        } else if (hour > 1) {
            return numberToText.convert(hour) + " " + "Hours";
        } else {
            return "";
        }
    }

    private String getMinuteFormat(int minutes) {
        if (minutes == 1) {
            return numberToText.convert(minutes) + " " + "Minute";
        } else if (minutes > 1) {
            return numberToText.convert(minutes) + " " + "Minutes";
        } else {
            return "";
        }
    }

    private String getSecondFormat(int seconds) {
        if (seconds == 1) {
            return numberToText.convert(seconds) + " " + "Second";
        } else if (seconds > 1) {
            return numberToText.convert(seconds) + " " + "Seconds";
        } else {
            return "";
        }
    }

    private String getMeridiemText(String meridiem) {
        if(meridiem.equals("AM")) {
            return "Morning";
        } else {
            return "Evening";
        }
    }
}