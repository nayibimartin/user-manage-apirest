package com.example.usermanageapirest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ErrorDetails {

	private String value;
	private String message;

}
