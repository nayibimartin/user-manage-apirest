package com.example.usermanageapirest.exception;

import lombok.Data;

import java.util.List;

@Data
public class BadRequest {

	List<String> errors;
}
