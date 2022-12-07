package com.board.main;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@RestController
public class LeagueBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeagueBoardApplication.class, args);
	}
	/*
	@Bean
	public CorsFilter corsFilter(){
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.addAllowedOrigin("http://localhost:4200");
		corsConfiguration.setAllowedHeaders(new ArrayList<>(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With","Access-Control-Request-Method", "Access-Control-Request-Headers")));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}*/

}
