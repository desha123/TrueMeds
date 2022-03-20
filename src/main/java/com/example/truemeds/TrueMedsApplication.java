package com.example.truemeds;

import com.example.truemeds.controllers.TrueMedsResourse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class TrueMedsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrueMedsApplication.class, args);
//		ApplicationContext con = SpringApplication.run(TrueMedsApplication.class, args);
//		TrueMedsResourse res = con.getBean(TrueMedsResourse.class);
//		res.removeAdjacentSimilarCharacters();
	}

}
