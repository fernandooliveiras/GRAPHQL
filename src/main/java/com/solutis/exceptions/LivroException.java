package com.solutis.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class LivroException extends RuntimeException implements GraphQLError {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> extensions = new HashMap<String, Object>();

    public LivroException(String mensagem, Long idInvalido) {
        super(mensagem);
        extensions.put("idInvalido", idInvalido);
    }

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}
	
	@Override
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	@Override
	public ErrorType getErrorType() {
		return ErrorType.DataFetchingException;
	}

}
