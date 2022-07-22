package com.honey.Barber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.honey.Barber.DAO.Admin.AdminRepoIMP;
import com.honey.Barber.DAO.SiteProperty.SitePropertyIMP;
import com.honey.Barber.DAO.SiteProperty.SitePropertyRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = "com.honey.Barber")
public class BarberShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarberShopApplication.class, args);
	}
	
}
