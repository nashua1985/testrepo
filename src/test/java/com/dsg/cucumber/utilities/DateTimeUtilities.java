package com.dsg.cucumber.utilities;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeUtilities {

    /**
     * This method returns current time stamp as a string.
     * @return current time stamp as a string
     */
    public static String getTimeStamp(){
            Date now = new Date();
            SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy_HH_mm_ss");
            String dateFormat = date.format(now);
            return dateFormat;
    }

    /**
     * This method returns difference between end and start time
     * @param start time
     * @param end time
     * @param format like h:m a --> 5:15 AM, 8:07 PM
     * @return difference between end time and start time as a long
     */
    public static long getTimeDifference(String start, String end, String format){
        LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern(format));
        LocalTime endTime = LocalTime.parse(end, DateTimeFormatter.ofPattern(format));
        return ChronoUnit.HOURS.between(startTime, endTime);
    }
}
