package com.fcommons.util;

import java.text.MessageFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * @author fdanismaz
 * @since 11/27/19
 */
public class DateTimeUtil {

    public static String getFirstDayOfLastMonthAsString(String format) {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfLastMonth = today.minus(1, ChronoUnit.MONTHS).withDayOfMonth(1);
        return firstDayOfLastMonth.format(DateTimeFormatter.ofPattern(format));
    }

    public static String getFirstDayOfNextMonthAsString(String format) {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfNextMonth = today.plus(1, ChronoUnit.MONTHS).withDayOfMonth(1);
        return firstDayOfNextMonth.format(DateTimeFormatter.ofPattern(format));
    }

    public static String getTodayAsString(String format) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }

    public static String getTomorrowAsString(String format) {
        return LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern(format));
    }

    public static String getDayAsString(LocalDate startDate, String format) {
        return startDate.format(DateTimeFormatter.ofPattern(format));
    }

    public static int getLastMonthValue() {
        return LocalDate.now().withDayOfMonth(1).minus(1, ChronoUnit.DAYS).getMonthValue();
    }

    public static String getLastMonthValueString() {
        int value = getLastMonthValue();
        return value < 10 ? MessageFormat.format("0{0}", value) : String.valueOf(value);
    }

    public static int getYearOfLastMonthValue() {
        return LocalDate.now().withDayOfMonth(1).minus(1, ChronoUnit.DAYS).getYear();
    }

    public static String getYearOfLastMonthValueString() {
        return String.valueOf(getYearOfLastMonthValue());
    }

    public static int getDayCountOfLastMonth() {
        LocalDate firstDayOfLastMonth = LocalDate.of(DateTimeUtil.getYearOfLastMonthValue(), DateTimeUtil.getLastMonthValue(), 1);
        return firstDayOfLastMonth.lengthOfMonth();
    }

    public static String getMonthValueAsString() {
        LocalDate today = LocalDate.now();
        int value = today.getMonthValue();
        return value < 10 ? MessageFormat.format("0{0}", value) : String.valueOf(value);
    }

    public static String getYearValueString() {
        LocalDate today = LocalDate.now();
        return String.valueOf(today.getYear());
    }

    public static LocalDate toLocalDate(String date, String format) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
    }

    /**
     * Inclusive (start, end are included within the rage) comparison of the date with the given start and end
     *
     * @param dateToCompare date to be compared
     * @param format        date format
     * @param start         the beginning of the date range
     * @param end           the end of the date range
     * @return              true if the given dateToCompare is in between the given start and end
     */
    public static boolean inBetween(String dateToCompare, String format, LocalDate start, LocalDate end) {
        LocalDate date = toLocalDate(dateToCompare, format);
        return date.compareTo(start) >= 0 && date.compareTo(end) <= 0;
    }

    public static boolean equalTo(String dateToCompare, String format, LocalDate comparedDate) {
        LocalDate date = toLocalDate(dateToCompare, format);
        return date.compareTo(comparedDate) == 0;
    }

    public static LocalDateTime toLocalDateTime(long epochTime, TimeZone timeZone) {
        if (timeZone == null){
            return null;
        }
        return Instant.ofEpochMilli(epochTime).atZone(timeZone.toZoneId()).toLocalDateTime();
    }

    public static LocalDateTime toLocalDateTime(long epochTime, ZoneId zoneId) {
        if (zoneId == null){
            return null;
        }
        return Instant.ofEpochMilli(epochTime).atZone(zoneId).toLocalDateTime();
    }

    public static LocalDateTime toLocalDateTime(Instant instant, TimeZone timeZone) {
        if (instant == null || timeZone == null){
            return null;
        }
        return LocalDateTime.ofInstant(instant, timeZone.toZoneId());
    }

    public static LocalDateTime toLocalDateTime(Instant instant, ZoneId zoneId) {
        if (instant == null || zoneId == null){
            return null;
        }
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    public static String toLocalDateTimeString(long epochTime, ZoneId zoneId, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return toLocalDateTimeString(epochTime, zoneId, formatter);
    }

    public static String toLocalDateTimeString(long epochTime, ZoneId zoneId, DateTimeFormatter formatlayici) {
        LocalDateTime localDateTime = toLocalDateTime(epochTime, zoneId);
        return localDateTime.format(formatlayici);
    }

    public static LocalDate toLocalDate(long epochTime, TimeZone timeZone) {
        if (timeZone == null){
            return null;
        }
        return Instant.ofEpochMilli(epochTime).atZone(timeZone.toZoneId()).toLocalDate();
    }

    public static LocalDate toLocalDate(long epochTime, ZoneId zoneId) {
        if (zoneId == null){
            return null;
        }
        return Instant.ofEpochMilli(epochTime).atZone(zoneId).toLocalDate();
    }

    public static LocalDate toLocalDate(Instant instant, TimeZone timeZone) {
        if (instant == null || timeZone == null){
            return null;
        }
        return LocalDateTime.ofInstant(instant, timeZone.toZoneId()).toLocalDate();
    }

    public static LocalDate toLocalDate(Instant instant, ZoneId zoneId) {
        if (instant == null || zoneId == null){
            return null;
        }
        return LocalDateTime.ofInstant(instant, zoneId).toLocalDate();
    }

    public static long toEpoch(LocalDateTime dateTime, TimeZone timeZone) {
        if (timeZone == null) {
            return 0;
        }
        return toEpoch(dateTime, timeZone.toZoneId());
    }

    public static long toEpoch(LocalDate date, TimeZone timeZone) {
        if (timeZone == null) {
            return 0;
        }
        return toEpoch(date, timeZone.toZoneId());
    }

    public static long toEpoch(LocalDateTime dateTime, ZoneId zoneId) {
        if (dateTime == null || zoneId == null) {
            return 0;
        }
        Instant instant = dateTime.atZone(zoneId).toInstant();
        return TimeUnit.SECONDS.toMillis(instant.getEpochSecond());
    }

    public static long toEpoch(LocalDate date, ZoneId zoneId) {
        if (date == null || zoneId == null) {
            return 0;
        }
        Instant instant = date.atStartOfDay().atZone(zoneId).toInstant();
        return TimeUnit.SECONDS.toMillis(instant.getEpochSecond());
    }

    public static long toEpoch(Instant instant) {
        if (instant == null) {
            return 0;
        }
        return TimeUnit.SECONDS.toMillis(instant.getEpochSecond());
    }

    public static Instant toInstant(LocalDate date, TimeZone timeZone) {
        if (date == null || timeZone == null){
            return null;
        }
        return date.atStartOfDay(timeZone.toZoneId()).toInstant();
    }

    public static Instant toInstant(LocalDate date, ZoneId zoneId) {
        if (date == null || zoneId == null){
            return null;
        }
        return date.atStartOfDay(zoneId).toInstant();
    }

    public static Instant toInstant(LocalDateTime dateTime, TimeZone timeZone) {
        if (dateTime == null || timeZone == null){
            return null;
        }
        return dateTime.toInstant(ZoneOffset.ofHours((int)TimeUnit.MICROSECONDS.toHours(timeZone.getRawOffset())));
    }

    public static Instant toInstant(long epoch) {
        return Instant.ofEpochMilli(epoch);
    }

    public static Instant toInstant(LocalDateTime dateTime, ZoneId zoneId) {
        if (dateTime == null || zoneId == null){
            return null;
        }
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
        return dateTime.toInstant(ZoneOffset.ofHours((int)TimeUnit.MICROSECONDS.toHours(timeZone.getRawOffset())));
    }
}
