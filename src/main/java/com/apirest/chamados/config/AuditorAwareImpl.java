package com.apirest.chamados.config;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public Optional<String> getCurrentAuditor() {
		String username = null;
		String jwtToken = null;
		final String requestTokenHeader = this.request.getHeader("Authorization");
		jwtToken = requestTokenHeader.substring(7);
		username = jwtTokenUtil.getUsernameFromToken(jwtToken);

		return Optional.of(username);
//		return Optional.of("Não encontrei");
	}
}
