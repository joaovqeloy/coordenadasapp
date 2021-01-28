package com.eloy.selecao.coordenadasapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.eloy.selecao")
public class CoordenadasappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoordenadasappApplication.class, args);
	}

}
