package tracker.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan({"tracker.controller"})
public class ApplicationTester extends SpringBootServletInitializer{
	
	@Override
	  protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
	      return builder.sources(ApplicationTester.class);
	  }
	

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTester.class, args);
	}
}
