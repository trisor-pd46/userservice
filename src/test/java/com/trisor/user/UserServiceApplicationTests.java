package com.trisor.user;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.oembedler.moon.graphql.boot.GraphQLWebAutoConfiguration;

@SpringBootTest
@Disabled
@EnableAutoConfiguration(exclude=GraphQLWebAutoConfiguration.class)
class UserServiceApplicationTests {

	@Test
	@Disabled
	void contextLoads() {
	}

}
