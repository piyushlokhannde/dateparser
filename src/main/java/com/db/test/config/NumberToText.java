package com.db.test.config;

public class NumberToText {



    public String convert(int number) {

        if(number >=0 && number <= 20){
            return NumberEnum.getText(number);
        } else if(number > 20 && number < 100) {
            return getNumericTextForTwoDigit(number);
        } else if(number > 100) {
           return getNumericTextForFourDigit(number);
        }

        return "";
    }

    private String getNumericTextForTwoDigit(int number) {
        int firstDigit = getFirstDigit(number);
        String firstDigitText = NumberEnum.getText(firstDigit);
        int secondDigit = getSecondDigit(number);
        String secondDigitText = NumberEnum.getText(secondDigit);
        return (secondDigitText +" "+firstDigitText).trim();
    }

    private int getFirstDigit(int number) {
       int firstDigit =  number%10;
       return firstDigit;
    }

    private int getSecondDigit(int number) {
        int seconDigit =  number/10;
        return seconDigit*10;
    }


    private String getNumericTextForFourDigit(int number) {
       int firstTwoDigit = getFirstTwoDigit(number);
       String firstTwoDigitText =  convert(firstTwoDigit);
       int lastTwoDigit = getLastTwoDigit(number);
        String lastTwoDigitText =  convert(lastTwoDigit);
        return (firstTwoDigitText+ " "+ lastTwoDigitText).trim();
    }

    private int getFirstTwoDigit(int number) {
        int firstTwoDigit =  number/100;
        return firstTwoDigit;
    }

    private int getLastTwoDigit(int number) {
        int firstDigit = number%10;
        int secondDigit = ((number/10)%10)*10;
        return secondDigit+firstDigit;
    }
}
