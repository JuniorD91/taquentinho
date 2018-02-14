package com.indra.taquentinho.util.exception;

public class VisaoException extends RuntimeException{

	private static final long serialVersionUID = 4191185536456519706L;

	private static final String message = "Ocorreu um erro ao acessar a base de dados";
	
	public VisaoException(String message) {
		super(message);
	}
	
}
