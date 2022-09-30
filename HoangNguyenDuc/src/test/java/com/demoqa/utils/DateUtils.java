package com.demoqa.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
    public final static String DEFAULT_DATE_TIME = "dd MMMM yyyy";

    public final static String SUB_DATE_TIME = "dd MMM yyyy";
    public static Date convertDateStringToDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME);
        return format.parse(dateString);
    }
    public static Date convertDateStringToSubDate(String dateString) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat(SUB_DATE_TIME);
        return format.parse(dateString);
    }
    public static String convertSubDateToDate(String dateString) throws ParseException {
        Date subDate = convertDateStringToSubDate(dateString);
        SimpleDateFormat subFormat = new SimpleDateFormat(DEFAULT_DATE_TIME);
        return subFormat.format(subDate);
    }
    public static Calendar getCalendar(Date date){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTime(date);
        return calendar;
    }
    public static String getDay(String dateString) throws ParseException {
        Date date = convertDateStringToDate(dateString);
        Calendar calendar = getCalendar(date);
        return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    }
    public static String getMonth(String dateString) throws ParseException {
        Date date = convertDateStringToDate(dateString);
        Calendar calendar = getCalendar(date);
        return (calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
    }
    public static String getYear(String dateString) throws ParseException {
        Date date = convertDateStringToDate(dateString);
        Calendar calendar = getCalendar(date);
        return String.valueOf(calendar.get(Calendar.YEAR));
    }
}
