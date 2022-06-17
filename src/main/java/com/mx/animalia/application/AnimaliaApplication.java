package com.mx.animalia.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@Configuration
@ComponentScan("com.mx.animalia")
@SpringBootApplication
public class AnimaliaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimaliaApplication.class, args);
	}

	//@Bean
	//public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		//return new JdbcTemplate(dataSource);
	//}

}
