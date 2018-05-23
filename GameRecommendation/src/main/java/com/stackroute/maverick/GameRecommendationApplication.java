package com.stackroute.maverick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("com.stackroute.maverick.repository")
@EnableDiscoveryClient
public class GameRecommendationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameRecommendationApplication.class, args);
	}
}
