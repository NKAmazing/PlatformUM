package com.project.PlatformUM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class PlatformUmApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();

        // Get the values from .env file
        String dbUrl = dotenv.get("DB_URL");
        String dbUsername = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");
        String dbDriverClassName = dotenv.get("DB_DRIVER_CLASS_NAME");

        // Configure the database settings as system properties
        System.setProperty("DB_URL", dbUrl);
        System.setProperty("DB_USERNAME", dbUsername);
        System.setProperty("DB_PASSWORD", dbPassword);
        System.setProperty("DB_DRIVER_CLASS_NAME", dbDriverClassName);

        // Spring boot application starter
		SpringApplication.run(PlatformUmApplication.class, args);
	}

}
