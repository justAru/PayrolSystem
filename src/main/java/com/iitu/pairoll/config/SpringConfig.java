package com.iitu.pairoll.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.iitu.pairoll")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "com.iitu.pairoll.repository")
public class SpringConfig {
}