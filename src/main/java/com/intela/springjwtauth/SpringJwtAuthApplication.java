package com.intela.springjwtauth;

import com.intela.springjwtauth.dto.RegisterRequest;
import com.intela.springjwtauth.services.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.intela.springjwtauth.models.Role.ADMIN;
import static com.intela.springjwtauth.models.Role.MANAGER;

@SpringBootApplication
public class SpringJwtAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJwtAuthApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService authenticationService
    ){
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstName("danish")
                    .lastName("saifi")
                    .email("danish@gmail.com")
                    .password("12345")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + authenticationService.register(admin).getToken());

            var manager = RegisterRequest.builder()
                    .firstName("Sibani")
                    .lastName("Patra")
                    .email("sibani@gmail.com")
                    .password("12345")
                    .role(MANAGER)
                    .build();
            System.out.println("Manager token: " + authenticationService.register(manager).getToken());
        };
    }
}
