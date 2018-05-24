package com.stackroute.maverick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableNeo4jRepositories("com.stackroute.maverick.repository")
@EnableDiscoveryClient
public class AdaptiveGameEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdaptiveGameEngineApplication.class, args);
	}
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        return builder.build();

    }
}
