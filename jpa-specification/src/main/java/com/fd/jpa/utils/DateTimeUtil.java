/*
 * Telif hakkı 2017 Türkiye Bilimsel ve Teknolojik Araştırma Kurumu.
 * Tüm haklar saklıdır.
 *
 * BU TELİF HAKKI DOSYA ÜST BİLGİSİNİ DEĞİŞTİRMEYİNİZ VEYA SİLMEYİNİZ.
 *
 * Bu kaynak kod sadece TÜBİTAK için TYBS Projesi kapsamında geliştirilmiştir;
 * değişiklik yapma, başka amaçlarda kullanılmak üzere kısmen veya tamamını
 * kopyalama ve/veya dağıtım yapma hakkınız bulunmamaktadır.
 *
 * Daha fazla bilgi ve sorularınız için TÜBİTAK ile iletişime geçiniz.
 */
package com.fd.jpa.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * @author furkan.danismaz
 * 10/09/2018 15:28
 */
public class DateTimeUtil {

	public static LocalDateTime toLocalDateTime(long epochTime, ZoneId zoneId) {
		return Instant.ofEpochMilli(epochTime).atZone(zoneId).toLocalDateTime();
	}

	public static LocalDateTime toLocalDateTime(Instant instant, TimeZone timeZone) {
		if (instant == null || timeZone == null){
			return null;
		}
		return LocalDateTime.ofInstant(instant, timeZone.toZoneId());
	}

	public static String toLocalDateTimeString(long epochTime, ZoneId zoneId, String pattern) {
		DateTimeFormatter formatlayici = DateTimeFormatter.ofPattern(pattern);
		return toLocalDateTimeString(epochTime, zoneId, formatlayici);
	}

	public static String toLocalDateTimeString(long epochTime, ZoneId zoneId, DateTimeFormatter formatlayici) {
		LocalDateTime localDateTime = toLocalDateTime(epochTime, zoneId);
		return localDateTime.format(formatlayici);
	}

	public static LocalDate toLocalDate(Instant instant, TimeZone timeZone) {
		if (instant == null || timeZone == null){
			return null;
		}
		return LocalDateTime.ofInstant(instant, timeZone.toZoneId()).toLocalDate();
	}

	public static long toEpoch(LocalDateTime dateTime, ZoneId zoneId) {
		Instant instant = dateTime.atZone(zoneId).toInstant();
		return TimeUnit.SECONDS.toMillis(instant.getEpochSecond());
	}

	public static long toEpoch(LocalDate date, ZoneId zoneId) {
		Instant instant = date.atStartOfDay().atZone(zoneId).toInstant();
		return TimeUnit.SECONDS.toMillis(instant.getEpochSecond());
	}

	public static long toEpoch(Instant instant) {
		return TimeUnit.SECONDS.toMillis(instant.getEpochSecond());
	}

	public static Instant toInstant(LocalDate date, TimeZone timeZone) {
		if (date == null || timeZone == null){
			return null;
		}
		return date.atStartOfDay(timeZone.toZoneId()).toInstant();
	}

	public static Instant toInstant(LocalDateTime dateTime, TimeZone timeZone) {
		if (dateTime == null || timeZone == null){
			return null;
		}
		return dateTime.toInstant(ZoneOffset.ofHours((int)TimeUnit.MICROSECONDS.toHours(timeZone.getRawOffset())));
	}

}
