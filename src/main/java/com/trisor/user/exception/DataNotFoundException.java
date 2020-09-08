package com.trisor.user.exception;

import java.util.List;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class DataNotFoundException extends RuntimeException implements GraphQLError{

	
	private static final long serialVersionUID = -8301214161967199394L;

	public DataNotFoundException(String message) {
		super(message);
	}
	
	@Override
	public List<SourceLocation> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		// TODO Auto-generated method stub
		return null;
	}

}
