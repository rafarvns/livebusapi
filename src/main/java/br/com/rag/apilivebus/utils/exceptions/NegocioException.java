package br.com.rag.apilivebus.utils.exceptions;

import java.util.ArrayList;
import java.util.List;

public class NegocioException extends RuntimeException {

	private List<String> messages;

	public NegocioException() {
		super();
		this.messages = new ArrayList<>();
	}

	public NegocioException(String message) {
		super(message);
		this.messages = new ArrayList<>();
		messages.add(message);
	}

	public NegocioException(List<String> messages) {
		super();
		this.messages = messages;
	}

	public NegocioException(String message, Throwable cause) {
		super(message, cause);
		if (cause instanceof NegocioException) {
			messages = ((NegocioException) cause).getMessages();
		} else {
			messages = new ArrayList<>();
		}
		messages.add(message);
	}

	public NegocioException(Throwable cause) {
		super(cause);
		if (cause instanceof NegocioException) {
			messages = ((NegocioException) cause).getMessages();
		} else {
			messages = new ArrayList<>();
		}
	}

	public List<String> getMessages() {
		return messages;
	}
}
