package com.demoqa.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
    public final static String DEFAULT_DATE_TIME = "dd MMMM yyyy";
    public static String convertDateStringToDateStringByFormat(String dateString, String dateFormat) throws ParseException {
        SimpleDateFormat subFormat = new SimpleDateFormat(dateFormat);
        Date convertDate = subFormat.parse(dateString);
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME);
        return format.format(convertDate);

    }
}
