package com.venkatakrishnans.cs6360.librarymanagement.Util;

import org.apache.commons.lang.time.DateUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTimeUtility {

    public static Date getCurrentDate() {
        return new Date(LocalDate.now().toEpochDay());
    }

    public static Date incrementDateBy(Date date,int daysToIncrement) {
        Date incrementedDate =  DateUtils.addDays(date,daysToIncrement);
        return incrementedDate;
    }

    public static long getDateDifferenceBetweenTwoDates(Date date1,Date date2,TimeUnit timeUnit){
        long differenceInMilliSeconds = date2.getTime() - date1.getTime();
        return timeUnit.convert(differenceInMilliSeconds,TimeUnit.MILLISECONDS);
    }
}
