# dateparser
This reposity impment the follwing problem:
Using OOAD,OOPS  concepts, write  a java program that  :

1)           Accepts an user input of date time in number format .

2)           This input  has following  Pattern dd-mm-yyyy hh:mm:ss AM/PM

3)           AM will be considered as Morning and PM will be considered as Evening

4)           Validate the date and time correctness without using java api

5)           In case of validation fails, print message invalid date time with input

6)           Prints the word equivalent of date and time

7)           Print the  day of the week for given input without using java api.

8)           This program will not use Java Calendar,  LocalDatetime and Day of week api .It can use java util date api for date creation only.

9)           Add junit test cases

For example 

Input date time : 21-01-2021 06:07:10 AM 

Output:

Valid Date : 21st-Jan -Twenty Twenty One

Valid Time : Six Hours Seven Minutes Ten Seconds - Morning

Day of week : Thursday 

# How To Execute the Program:

This is simple java program and execute using main class. Minimum requiremnt is java 8 version. This program can be execute by running class **DateParser.java**

**valid Date**  <br/>
Enter the date to be parse<br/>
16-04-2021 06:07:10 AM<br/>

**Output**<br/>
Valid Date : 16th-Apr-Twenty Twenty One<br/>
Valid Time : Six Hours Seven Minutes Ten Seconds - Morning<br/>
Day of week: Friday<br/>

**invalid Date**<br/>
Enter the date to be parse<br/>
31-04-2021 06:07:10 AM<br/>
 
**Output** <br/>
Maximum Number of Days in Month are not valid<br/>  

# Class Dependcies:

 ![alt text](class_diagram.jpg)
 
 # Sequece Diagram:
 ![alt text](sequence_diagram.jpg)
