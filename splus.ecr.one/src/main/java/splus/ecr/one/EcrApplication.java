package splus.ecr.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import splus.ecr.one.configuration.EcrJpaConfiguration;





@Import(EcrJpaConfiguration.class)
@SpringBootApplication
public class EcrApplication extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EcrApplication.class);
    }
	
	public static void main(String[] args){
		SpringApplication.run(EcrApplication.class, args);
	}

}
