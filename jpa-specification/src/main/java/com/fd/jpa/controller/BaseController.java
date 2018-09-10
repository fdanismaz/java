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
