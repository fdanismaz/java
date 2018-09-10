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

import com.fd.jpa.converter.CycleAvoidingMappingContext;
import com.fd.jpa.converter.PersonEntityMapper;
import com.fd.jpa.entity.PersonEntityModel;
import com.fd.jpa.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

/**
 * @author furkan.danismaz
 * 10/09/2018 13:48
 */
@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController extends BaseController {

	@Autowired
	private PersonEntityMapper personEntityMapper;

	@GetMapping("/{id}")
	public Person getPerson() {
		return new Person(1, "furkan", "danismaz", LocalDate.of(1985, 12, 7));
	}

	@PostMapping
	public Person savePerson(@RequestBody Person person, HttpServletRequest request) {
		PersonEntityModel personEntityModel = this.personEntityMapper.toEntityModel(person, new CycleAvoidingMappingContext(), this.getRequestTimeZone());
		log.debug(personEntityModel.toString());
		return null;
	}

}
