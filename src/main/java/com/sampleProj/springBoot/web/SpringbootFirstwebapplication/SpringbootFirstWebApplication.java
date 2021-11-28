package com.sampleProj.springBoot.web.SpringbootFirstwebapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootFirstWebApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootFirstWebApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirstWebApplication.class, args);
	}

}
