package com.dsg.cucumber.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportUtilities {
    
    public static String formattedDateTime()
    {

        Date now = new Date();

        SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy_HHmmss");

        String dateFormat = date.format(now);

        return dateFormat;

    }

}
