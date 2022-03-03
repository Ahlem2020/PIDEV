package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import tn.esprit.spring.services.EmailSenderService;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class WomenEmpowermentApplication {

	public static void main(String[] args) {
		SpringApplication.run(WomenEmpowermentApplication.class, args);
	}

}
