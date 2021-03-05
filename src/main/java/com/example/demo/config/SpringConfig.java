package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
public class SpringConfig {
}
