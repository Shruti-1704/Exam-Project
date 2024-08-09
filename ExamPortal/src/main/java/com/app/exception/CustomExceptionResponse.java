package com.app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomExceptionResponse extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String a;
	public String message;
	public String b;
	
	public CustomExceptionResponse(String a, String message, String b) {
		super();
		this.a = a;
		this.message = message;
		this.b = b;
	}
	
	

}