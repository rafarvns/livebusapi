package br.com.rag.apilivebus.utils.exceptions;

public class FaturaImportacaoException extends RuntimeException {

	public FaturaImportacaoException(String message) {
		super(message);
	}

	public FaturaImportacaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public FaturaImportacaoException(Throwable cause) {
		super(cause);
	}
}
