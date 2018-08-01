package sep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateParserTest {
    DateParser parseDate;

    @BeforeEach
    void setup() {
        parseDate = new DateParser();
    }

    @Test
    void canaryTest() {
        assertTrue(true);
    }

    @Test
    void getYearTest() {
        assertEquals(2008, parseDate.getYearOfBirth(2008));
    }

    @Test
    void getMonthTest() {
        assertEquals(11, parseDate.getMonthOfBirth(11, 2008));
    }

    @Test
    void getMonthTest2() {
        assertEquals(11, parseDate.getMonthOfBirth(11, 1582));
    }

    @Test
    void getDayTest() {
        assertEquals(8, parseDate.getDayOfBirth(2008, 11, 8));
    }

    @Test
    void findDayOfBirthTest() {
        assertEquals("Saturday", parseDate.findDayOfBirth(2008,11,8));
    }

    @Test
    void retrieveDayOfBirthTest() {
        assertEquals("You were born on a Saturday", parseDate.retrieveDayOfBirth(2008, 11, 8));
    }

    @Test
    void getYearTestExceptionThrownTest() {
        Throwable exception = assertThrows(RuntimeException.class, () -> parseDate.getYearOfBirth(-1));
        assertEquals("Invalid year doesn't fall into Gregorian Calender (October 1582 - Current Year)", exception.getMessage());
    }

    @Test
    void getMonthTestExceptionThrownTest() {
        Throwable exception = assertThrows(RuntimeException.class, () -> parseDate.getMonthOfBirth(-1, 2008));
        assertEquals("Invalid month", exception.getMessage());
    }

    @Test
    void getDayTestExceptionThrownTest() {
        Throwable exception = assertThrows(RuntimeException.class, () -> parseDate.getDayOfBirth(2016, 2, 30));
        assertEquals("Invalid day", exception.getMessage());
    }

    @Test
    void getDayTestExceptionThrownTest2() {
        Throwable exception = assertThrows(RuntimeException.class, () -> parseDate.getDayOfBirth(2015, 2, 29));
        assertEquals("Invalid day", exception.getMessage());
    }

    @Test
    void getDayTestExceptionThrownTest3() {
        Throwable exception = assertThrows(RuntimeException.class, () -> parseDate.getDayOfBirth(2016, 9, 31));
        assertEquals("Invalid day", exception.getMessage());
    }

    @Test
    void getDayTestExceptionThrownTest4() {
        Throwable exception = assertThrows(RuntimeException.class, () -> parseDate.getDayOfBirth(2016, 1, 32));
        assertEquals("Invalid day", exception.getMessage());
    }
}
