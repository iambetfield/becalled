package com.iternova.becalled;

import com.iternova.becalled.user.User;
import com.iternova.becalled.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BecalledApplication {

	public static void main(String[] args) {
		SpringApplication.run(BecalledApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService service){
		return args -> {
			service.register(User.builder()
					.username("Betfield")
					.email("nmalvarez@gmail.com")
					.password("666")
					.build()
			);
			service.register(User.builder()
					.username("Caro")
					.email("caro_dito@hotmail.com")
					.password("111")
					.build()
			);
			service.register(User.builder()
					.username("vickinuni")
					.email("vicky@gmail.com")
					.password("teamo")
					.build());
		};
	}
}
