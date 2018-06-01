package com.stackroute.maverick.config;

import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;import io.micrometer.core.instrument.MeterRegistry;@Configuration
public class MetricsConfig {   
   
	//method for grafana to implement in application
    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> {
            registry.config().commonTags("application", "game-recommendation-service");
        };
    }
}
