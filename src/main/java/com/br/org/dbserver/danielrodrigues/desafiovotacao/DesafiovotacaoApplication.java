package com.br.org.dbserver.danielrodrigues.desafiovotacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafiovotacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiovotacaoApplication.class, args);
	}

}
