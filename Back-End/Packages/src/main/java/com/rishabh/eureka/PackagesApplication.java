package com.rishabh.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@CrossOrigin(origins = "http://localhost:4200")
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.rishabh"})
public class PackagesApplication {
	 @Bean
	    public WebMvcConfigurer corConfigurer()
	    {
	    	return new WebMvcConfigurer() {
	    		@Override
	    		public void addCorsMappings(CorsRegistry registry) {
	    			// TODO Auto-generated method stub
	    			registry.addMapping("/*").allowedHeaders("*").allowedMethods("*").allowedOriginPatterns("*")
	    			.allowCredentials(true);
	    			
	    		}
			};
	    }

	public static void main(String[] args) {
		SpringApplication.run(PackagesApplication.class, args);
	}

}
