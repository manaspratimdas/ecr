package splus.ecr.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import splus.ecr.one.configuration.EcrJpaConfiguration;





@Import(EcrJpaConfiguration.class)
@SpringBootApplication
public class EcrApplication {
	
	public static void main(String[] args){
		SpringApplication.run(EcrApplication.class, args);
	}

}
