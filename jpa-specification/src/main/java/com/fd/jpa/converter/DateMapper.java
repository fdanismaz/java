package com.fd.jpa.converter;

import com.fd.jpa.utils.DateTimeUtil;
import org.mapstruct.Context;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * @author furkan.danismaz
 * 10/09/2018 15:26
 */
@Component
public class DateMapper {

	public Instant toInstant(LocalDateTime localDateTime, @Context TimeZone timeZone) {
		return DateTimeUtil.toInstant(localDateTime, timeZone);
	}

	public LocalDateTime toLocalDateTime(Instant instant, @Context TimeZone timeZone) {
		return DateTimeUtil.toLocalDateTime(instant, timeZone);
	}

	public Instant toInstant(LocalDate localDate, @Context TimeZone timeZone) {
		return DateTimeUtil.toInstant(localDate, timeZone);
	}

	public LocalDate toLocalDate(Instant instant, @Context TimeZone timeZone) {
		return DateTimeUtil.toLocalDate(instant, timeZone);
	}

	public LocalDateTime toLocalDateTime(long epoch, @Context TimeZone timeZone) {
		return DateTimeUtil.toLocalDateTime(epoch, timeZone.toZoneId());
	}

	public long toEpoch(LocalDateTime localDateTime, @Context TimeZone timeZone) {
		return DateTimeUtil.toEpoch(localDateTime, timeZone.toZoneId());
	}
}
