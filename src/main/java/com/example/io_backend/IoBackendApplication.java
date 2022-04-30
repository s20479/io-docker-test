package com.example.io_backend;

import com.example.io_backend.model.dto.representations.UserRepresentation;
import com.example.io_backend.service.KeycloakService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;
import java.util.List;

@SpringBootApplication
@Slf4j
public class IoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(IoBackendApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Autowired
	private KeycloakService keycloakService;

	@PreDestroy
	// todo good idea is to create a cronjob that is running i.e. once a day and checks if users present in our db are also in keycloak db, and if not delete them from keycloak
	public void deleteKeycloakUsersOnExit() {
		List<UserRepresentation> users = keycloakService.getUsers();

		users.forEach(x -> {
			keycloakService.deleteUser(x);
		});

		log.info("Users deleted");
	}

}
