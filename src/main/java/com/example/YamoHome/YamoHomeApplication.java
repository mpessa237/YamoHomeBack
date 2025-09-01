package com.example.YamoHome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class YamoHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(YamoHomeApplication.class, args);
	}

	@Bean
	public SpringSecurityAuditorAware auditorAware() {
		// Le type générique a été changé en Long
		return new SpringSecurityAuditorAware();
	}
}
