package com.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan({"com.tracker"})
//@EnableAutoConfiguration
@SpringBootApplication
public class ApplicationTester{
	
	/*@Override
	  protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
	      return builder.sources(ApplicationTester.class);
	  }*/
	

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTester.class, args);
	}
}
