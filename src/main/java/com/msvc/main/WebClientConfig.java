package com.msvc.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
	@Value("${spring.application.external-services.ms-prodcuts}")
	private String msProductsUrl;

	@Bean
	@LoadBalanced
	WebClient.Builder webCLient(){
		return WebClient.builder().baseUrl(msProductsUrl);
	}
}


