package com.mentaldiary.mentalapi;

import com.mentaldiary.mentalapi.config.GracefulShutdown;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MentalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MentalApiApplication.class, args);
    }

    @Bean
    public GracefulShutdown gracefulShutdown() {
        return new GracefulShutdown();
    }

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}

}
