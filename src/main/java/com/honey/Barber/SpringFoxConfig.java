package com.honey.Barber;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.honey.Barber.Beans.Customer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.honey.*"))
				.paths(PathSelectors.any()).build();
	}

}