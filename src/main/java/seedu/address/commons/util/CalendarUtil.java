package seedu.address.commons.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * A container for Calendar specific utility functions.
 */
public class CalendarUtil {

    public static int getCurrentMonth() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return calendar.get(Calendar.MONTH);
    }

    public static int getCurrentYear() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return calendar.get(Calendar.YEAR);
    }

    /**
     * Gets current month in String format
     */
    public static String getMonthString(int monthIndex) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};
        return months[monthIndex];
    }

    /**
     * Returns the day of the week of the first day of the particular month
     * @param monthIndex the month to be passed in
     * @return the index of the day of the week of the first day
     */
    public static int dayOfFirstDayOfMonth(int year, int monthIndex) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        calendar.set(year, monthIndex, 1);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
