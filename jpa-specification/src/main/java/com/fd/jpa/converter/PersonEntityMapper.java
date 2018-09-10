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

import com.fd.jpa.entity.PersonEntityModel;
import com.fd.jpa.model.Person;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.TimeZone;

/**
 * @author furkan.danismaz
 * 10/09/2018 15:41
 */
@Mapper(config = EntityMapperConfig.class, componentModel = "spring")
public interface PersonEntityMapper {

	Person toBusinessModel(PersonEntityModel entityModel,
						   @Context CycleAvoidingMappingContext context,
						   @Context TimeZone timeZone);

	PersonEntityModel toEntityModel(Person p,
									@Context CycleAvoidingMappingContext context,
									@Context TimeZone timeZone);
}
