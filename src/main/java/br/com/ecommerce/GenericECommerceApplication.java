package br.com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class GenericECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenericECommerceApplication.class, args);
	}

}
