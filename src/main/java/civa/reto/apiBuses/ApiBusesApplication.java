package civa.reto.apiBuses;

import civa.reto.apiBuses.model.Auth;
import civa.reto.apiBuses.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiBusesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBusesApplication.class, args);
	}

}
