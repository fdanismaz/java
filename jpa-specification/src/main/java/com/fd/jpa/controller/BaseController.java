package com.fd.jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.TimeZone;

/**
 * @author furkan.danismaz
 * 10/09/2018 16:01
 */
@Slf4j
public class BaseController {

	public HttpServletRequest getRequest() {
		try {
			return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		} catch (IllegalStateException e) {
			log.warn("Cannot access request object. " + e.getMessage(), e);
			return null;
		}
	}

	public TimeZone getRequestTimeZone() {
		TimeZone timeZone = RequestContextUtils.getTimeZone(this.getRequest());
		if (timeZone == null) {
			return TimeZone.getDefault();
		}
		return timeZone;
	}


}
