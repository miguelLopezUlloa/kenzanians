package com.mikauran.kenzanians;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class KenzaniansApplication extends SpringBootServletInitializer {  {

	
	@Override
	protected SpringApplicationBuilder
	configure(SpringApplicationBuilder application){
		return application.sources(KenzaniansApplication.class);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(KenzaniansApplication.class, args);
	}

}
