package com.example.usermanageapirest.application.controller.user.request;

import com.example.usermanageapirest.application.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class UserPageableCreator {
	private final ParameterValueDecider parameterValueDecider;
	private final Validator<String> orderValidator;
	private final Validator<Integer> pageValidator;
	private final Validator<Integer> sizeValidator;

	public final static int DEFAULT_PAGE = 0;
	public final static int DEFAULT_SIZE = 20;
	public final static String DEFAULT_SORT = "firstName.asc";

	@Autowired
	public UserPageableCreator(
		ParameterValueDecider parameterValueDecider,
		Validator<String> orderValidator,
		Validator<Integer> pageValidator,
		Validator<Integer> sizeValidator
	) {
		this.parameterValueDecider = parameterValueDecider;
		this.orderValidator = orderValidator;
		this.pageValidator = pageValidator;
		this.sizeValidator = sizeValidator;
	}

	public Pageable create(Integer page, Integer size, String sort) {
		String sortValue = this.parameterValueDecider.decideValue(
			sort,
			DEFAULT_SORT,
			this.orderValidator
		);
		String[] sortSplit = sortValue.split("\\.");

		return PageRequest.of(
			this.parameterValueDecider.decideValue(page, DEFAULT_PAGE, this.pageValidator),
			this.parameterValueDecider.decideValue(size, DEFAULT_SIZE, this.sizeValidator),
			(sortSplit[1].equals("asc")) ? Sort.by(sortSplit[0]).ascending() : Sort.by(sortSplit[0]).descending()
		);
	}

}
