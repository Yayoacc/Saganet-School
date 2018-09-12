package com.saganet.school.auditory;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Obtener el Usuario utilizando Spring Security
		// return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
		return Optional.of("develop");
	}
}
