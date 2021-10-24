package br.com.saolucas.financemanager.shared.exception.handler.domain;

import java.time.Instant;
import java.util.List;

public class InvalidFieldResponse {
	private String message;
	private Integer status;
	private Instant instant;
	private List<InvalidField> errors;
	
	public InvalidFieldResponse(String message, Integer status, List<InvalidField> errors) {
		this.message = message;
		this.status = status;
		this.instant = Instant.now();
		this.errors = errors;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public Instant getInstant() {
		return this.instant;
	}
	
	public List<InvalidField> getErrors() {
		return this.errors;
	}
}
