package com.mobileapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

/**
 * Конфигурация бинов для Spring Security. Здесь настраиваются компоненты типов
 * {@link Http403ForbiddenEntryPoint}
 *
 */
@Configuration
public class SpringSecurityBeans {

	private UserDetailsService userDetailsService;

	@Autowired
	public SpringSecurityBeans(final UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public Http403ForbiddenEntryPoint http403ForbiddenEntryPoint () {
		return new Http403ForbiddenEntryPoint ();
	}

	public UserDetailsService getUserDetailsService () {
		return userDetailsService;
	}

	public void setUserDetailsService (UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
}
