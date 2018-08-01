package sep;

import java.util.Calendar;

public class DateParser {
        String[] Days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        private int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        public int getYearOfBirth(int year) {
            checkForInvalidEntry(year, 1582, currentYear, "year doesn't fall into Gregorian Calender (October 1582 - Current Year)");
            return year;
        }

        public int getMonthOfBirth(int month, int year) {
            if(year == 1582)
                checkForInvalidEntry(month, 10, 12, "month");
            else
                checkForInvalidEntry(month, 1,12, "month");
            return month;
        }

        public int getDayOfBirth(int year, int month, int day) {
            checkForInvalidDay(year, month, day);
            return day;
        }

        public String findDayOfBirth(int year, int month, int day) {
            int a = (14-month)/12;
            int y = year-a;
            int m = month+12*a-2;
            int d = (day+y+y/4-y/100+y/400+(31*m/12))%7;

            return Days[d];
        }

        public String retrieveDayOfBirth(int readYear, int readMonth, int readDay) {
            System.out.println("You were born on a " + findDayOfBirth(readYear, readMonth, readDay));

            return "You were born on a " + findDayOfBirth(readYear, readMonth, readDay);
        }

        public void checkForInvalidEntry(int variableToCheck, int firstNum, int secondNum, String exception) {
            if(variableToCheck < firstNum || variableToCheck > secondNum) {
                throw new RuntimeException("Invalid " + exception);
            }
        }

        public void checkForInvalidDay(int year, int month, int day) {
            int leapYear = year % 4;

            if ((leapYear != 0) && (month == 2) && (day < 1 || day > 28))
                throw new RuntimeException("Invalid day");
            if ((leapYear == 0) && (month == 2) && (day < 1 || day > 29))
                throw new RuntimeException("Invalid day");
            if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30))
                throw new RuntimeException("Invalid day");
            if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day < 1 || day > 31))
                throw new RuntimeException("Invalid day");
        }
}
