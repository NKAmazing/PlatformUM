package com.project.PlatformUM;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.elasticsearch.RestClientBuilderCustomizer;
// import org.springframework.boot.web.client.RestTemplateBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.web.client.RestTemplate;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class PlatformUmApplication {

    private static final Logger log = LoggerFactory.getLogger(PlatformUmApplication.class);

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

    // This method is used to create a RestTemplate bean which is used to make HTTP requests.
	// @Bean
    // public RestTemplate restTemplate(RestTemplateBuilder builder) {
	// 	return builder.build();
	// }

    // // This method is used to make a HTTP request to the API and print the response.
    // @Bean
    // public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
	// 	return args -> {
	// 		Quote quote = restTemplate.getForObject(
	// 				"http://localhost:9000/api/", Quote.class);
	// 		log.info(quote.toString());
	// 	};
	// }

}
