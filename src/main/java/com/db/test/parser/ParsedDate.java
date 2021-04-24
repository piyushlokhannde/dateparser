package com.db.test.parser;


public class ParsedDate {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int second;
    private String meridian;


    public int getDay() {
        return day;
    }



    public int getMonth() {
        return month;
    }


    public int getYear() {
        return year;
    }



    public int getHour() {
        return hour;
    }


    public int getMinute() {
        return minute;
    }



    public int getSecond() {
        return second;
    }


    public String getMeridian() {
        return meridian;
    }


    public static class ParsedDateBuilder {
        private String day;
        private String month;
        private String year;
        private String hour;
        private String minute;
        private String second;
        private String meridian;

        public ParsedDateBuilder ofDay(String day) {
            this.day = day;
            return this;
        }

        public ParsedDateBuilder ofMonth(String month) {
            this.month = month;
            return this;
        }

        public ParsedDateBuilder ofYear(String year) {
            this.year = year;
            return this;
        }

        public ParsedDateBuilder ofHour(String hour) {
            this.hour = hour;
            return this;
        }

        public ParsedDateBuilder ofMinute(String minute) {
            this.minute = minute;
            return this;
        }

        public ParsedDateBuilder ofSecond(String second) {
            this.second = second;
            return this;
        }

        public ParsedDateBuilder ofMeridian(String meridian) {
            this.meridian = meridian;
            return this;
        }

        public ParsedDate build() {
            ParsedDate parsedDate = new ParsedDate();
            parsedDate.day = Integer.valueOf(day);
            parsedDate.month = Integer.valueOf(month);
            parsedDate.year = Integer.valueOf(year);
            parsedDate.hour = Integer.valueOf(hour);
            parsedDate.minute = Integer.valueOf(minute);
            parsedDate.second = Integer.valueOf(second);
            parsedDate.meridian = meridian;
            return parsedDate;
        }

    }


}
