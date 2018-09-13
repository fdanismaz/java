package com.fd.jpa.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author furkan.danismaz
 * 10/09/2018 13:10
 */
public class SpringSecurityAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("fdanismaz");
	}
}
