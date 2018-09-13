package com.fd.jpa.converter;

import org.mapstruct.MapperConfig;

/**
 * @author furkan.danismaz
 * 10/09/2018 15:40
 */
@MapperConfig(uses = DateMapper.class, componentModel = "spring")
public interface EntityMapperConfig {
}
