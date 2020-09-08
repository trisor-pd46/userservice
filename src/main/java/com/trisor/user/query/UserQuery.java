package com.trisor.user.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.trisor.user.model.User;
import com.trisor.user.service.UserService;

@Component
public class UserQuery  implements GraphQLQueryResolver{
	
	@Autowired
	private UserService userService;
	
	public User getUserById(Long id) {
		return userService.getUserById(id);
	}
	

}
