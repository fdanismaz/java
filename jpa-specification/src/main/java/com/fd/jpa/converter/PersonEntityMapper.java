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
package com.fd.jpa.converter;

import com.fd.jpa.entity.PersonEntity;
import com.fd.jpa.model.Person;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.TimeZone;

/**
 * @author furkan.danismaz
 * 10/09/2018 15:41
 */
@Mapper(config = EntityMapperConfig.class, componentModel = "spring")
public interface PersonEntityMapper {

	Person toBusinessObject(PersonEntity entity,
							@Context CycleAvoidingMappingContext context,
							@Context TimeZone timeZone);

	PersonEntity toEntity(Person bo,
						  @Context CycleAvoidingMappingContext context,
						  @Context TimeZone timeZone);


	List<PersonEntity> toEntityList(List<Person> boList,
									@Context CycleAvoidingMappingContext context,
									@Context TimeZone timeZone);

	List<Person> toBusinessObjectList(List<PersonEntity> entityList,
									  @Context CycleAvoidingMappingContext context,
									  @Context TimeZone timeZone);

}
