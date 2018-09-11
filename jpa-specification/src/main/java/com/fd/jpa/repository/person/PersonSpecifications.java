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
package com.fd.jpa.repository.person;

import com.fd.jpa.entity.PersonEntity;
import com.fd.jpa.entity.PersonEntity_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author furkan.danismaz
 * 11/09/2018 16:41
 */
public class PersonSpecifications {

	public static Specification<PersonEntity> withName(String name) {
		return new Specification<PersonEntity>() {
			@Override
			public Predicate toPredicate(Root<PersonEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.get(PersonEntity_.name), name);
			}
		};
	}

	public static Specification<PersonEntity> withSurname(String surname) {
		return new Specification<PersonEntity>() {
			@Override
			public Predicate toPredicate(Root<PersonEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.get(PersonEntity_.surname), surname);
			}
		};
	}
}
