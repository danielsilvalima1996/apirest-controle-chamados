package com.apirest.chamados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ControleChamadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleChamadosApplication.class, args);
	}

}
