package com.sivadas.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sivadas.anand.entity.repository.CustomRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
public class SpringBootDataApplication {

	public static void main(final String[] args) {
		SpringApplication.run(SpringBootDataApplication.class, args);
	}

}
