package sep.ui;

import sep.DateParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DateParserUI {
    public static void main(String[] args) {
        DateParser parseDate = new DateParser();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean caughtYear = true;
        boolean caughtMonth = true;
        boolean caughtDay = true;
        int readYear = 0;
        int readMonth = 0;
        int readDay = 0;
        String input = "";

        while(caughtYear) {
            try {
                System.out.println("Enter your year of birth");
                input = reader.readLine();
                readYear = Integer.parseInt(input);
                parseDate.getYearOfBirth(readYear);
                caughtYear = false;
            } catch (IOException | NumberFormatException e) {
                System.out.println(e + " Invalid input, please enter an Integer");
            } catch (RuntimeException msg) {
                System.out.println(msg);
            }
        }

        while(caughtMonth) {
            try {
                System.out.println("Enter your month of birth");
                input = reader.readLine();
                readMonth = Integer.parseInt(input);
                parseDate.getMonthOfBirth(readMonth, readYear);
                caughtMonth = false;
            } catch (IOException | NumberFormatException e) {
                System.out.println(e + " Invalid input, please enter an Integer");
            } catch (RuntimeException msg) {
                System.out.println(msg);
            }
        }

        while(caughtDay) {
            try {
                System.out.println("Enter your day of birth");
                input = reader.readLine();
                readDay = Integer.parseInt(input);
                parseDate.getDayOfBirth(readYear, readMonth, readDay);
                caughtDay = false;
            } catch (IOException | NumberFormatException e) {
                System.out.println(e + " Invalid input, please enter an Integer");
            } catch (RuntimeException msg) {
                System.out.println(msg);
            }
        }
        parseDate.retrieveDayOfBirth(readYear, readMonth, readDay);
    }
}
