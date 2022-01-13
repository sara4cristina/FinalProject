package com.unibuc.assig.FinalProject;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Slf4j
@SpringBootApplication
public class FinalProjectApplication {

	public static void main(String[] args) {


		SpringApplication.run(FinalProjectApplication.class, args);
		log.warn("Undeva in main");
	}

}
