package com.trisor.user.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
@Value(value = "${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
	private String jwkURI;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests(authorize -> authorize.antMatchers("*/graphiql/**","*/actuator/**").permitAll().anyRequest().authenticated())
		.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(buildJwtAuthenticationConverter())))
		.csrf().disable();
	}

	private JwtAuthenticationConverter buildJwtAuthenticationConverter() {
		JwtAuthenticationConverter jwtAuthConverter = new JwtAuthenticationConverter();
		jwtAuthConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
			List<Object> roles = (List<Object>) jwt.getClaims().getOrDefault("cognito:groups", Collections.emptyList());
			return roles.stream().map(Object::toString).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		});
		
		return jwtAuthConverter;
	}

	@Bean
	public JwtDecoder customDecoder(OAuth2ResourceServerProperties properties) {
		NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(properties.getJwt().getJwkSetUri()).build();
		jwtDecoder.setClaimSetConverter(new UserClaimsAdapter());
		return jwtDecoder;
	}

}