package com.example.usermanageapirest.application.configuration.spring;

import com.example.usermanageapirest.application.configuration.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {

	private final UserConverter converter;

	@Autowired
	public WebConfig(UserConverter converter) {
		this.converter = converter;
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("POST", "GET", "PUT", "PATCH", "DELETE")
			.allowedHeaders(
				"Accept",
				"Accept-Version",
				"Content-Length",
				"Content-Type",
				"Authorization"
			)
			.maxAge(3600);
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(this.converter);
	}
}
