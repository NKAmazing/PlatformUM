package com.project.PlatformUM;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;


@SpringBootApplication
public class PlatformUmApplication {

    private static final Logger log = LoggerFactory.getLogger(PlatformUmApplication.class);

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();

        String dbUrl = dotenv.get("DB_URL");
        String dbUsername = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");
        String dbDriverClassName = dotenv.get("DB_DRIVER_CLASS_NAME");
        String serverPort = dotenv.get("SERVER_PORT");

        System.setProperty("DB_URL", dbUrl);
        System.setProperty("DB_USERNAME", dbUsername);
        System.setProperty("DB_PASSWORD", dbPassword);
        System.setProperty("DB_DRIVER_CLASS_NAME", dbDriverClassName);

        System.setProperty("SERVER_PORT", serverPort);

		SpringApplication.run(PlatformUmApplication.class, args);
	}

}
