package com.trisor.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.oembedler.moon.graphql.boot.GraphQLWebAutoConfiguration;

@SpringBootApplication
public class UserServiceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
