package edu.eci.arsw.GuidFinderAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw"})
public class GuidFinderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuidFinderApiApplication.class, args);
	}

}
