package com.adailsilva.iotenergymeter.api.services.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserAndDeveloperError {

//	@EqualsAndHashCode.Include
//	@Id
//	private Long id;

	private String userMessage;

	private String developMessage;

	public UserAndDeveloperError() {
		super();
	}

	public UserAndDeveloperError(String userMessage, String developMessage) {
		super();
		this.userMessage = userMessage;
		this.developMessage = developMessage;
	}

	@Override
	public String toString() {
		return "Erro [userMessage=" + userMessage + ", developMessage=" + developMessage + "]";
	}

}
