package com.fcommons.rest;

import com.fcommons.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * @author fdanismaz
 * @since 11/26/19
 */
@Slf4j
@Component
public class RequestContext {

    public HttpServletRequest request() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        } catch (IllegalStateException e) {
            log.warn("Cannot access request object. " + e.getMessage(), e);
            return null;
        }
    }

    public HttpServletResponse response() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
    }

    /**
     * The time zone of the request. It is determined by the Time-Zone header of the request.
     * If it is not set, then the method returns the default time zone of the server
     *
     * @return Time zone of the request
     */
    public TimeZone timeZone() {
        String timeZoneHeader = this.request().getHeader("Time-Zone");
        if (timeZoneHeader != null) {
            try {
                int zoneOffsetValue = Integer.parseInt(timeZoneHeader);
                ZoneOffset zoneOffset = ZoneOffset.ofTotalSeconds((int) TimeUnit.HOURS.toSeconds(zoneOffsetValue));
                return TimeZone.getTimeZone(zoneOffset);
            } catch (NumberFormatException e) {
                log.error("Cannot parse Time-Zone header");
            } catch (Exception e) {
                log.error("Cannot set request time-zone");
            }
        }

        return TimeZone.getDefault();
    }

    /**
     * This method converts the Instant.now() to LocalDateTime based on the request time zone.
     * The request time zone is set based on the Time-Zone header of the request. If it is
     * not set, than the server's default time-zone is used.
     *
     * @return The current time based on the client's time zone
     */
    public LocalDateTime clientTime() {
        return DateTimeUtil.toLocalDateTime(Instant.now(), this.timeZone());
    }

    /**
     * This method converts the Instant.now() to LocalDateTime based on the request time zone.
     * The request time zone is set based on the Time-Zone header of the request. If it is
     * not set, than the server's default time-zone is used.
     *
     * @return The current time based on the client's time zone epoch milisecond value
     */
    public long clientTimeToEpoch() {
        return DateTimeUtil.toEpoch(DateTimeUtil.toLocalDateTime(Instant.now(), this.timeZone()), this.timeZone());
    }
}
