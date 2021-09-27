package com.example.usermanageapirest.application.validator;

import com.example.usermanageapirest.domain.services.Sort;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrderValidator implements Validator<String> {

	private static String ORDER_VALID_FORMAT = "^\\w+\\.\\w+$";

	@Override
	public boolean isValid(String order) {

		if(Objects.isNull(order) || order.isBlank()) {
			return false;
		}
		if(!order.matches(ORDER_VALID_FORMAT)) {
			return false;
		}
		String[] orderSplitted = order.split("\\.");
		if(!Sort.SortFields.isSortFieldValid(orderSplitted[0])) {
			return false;
		}
		if(!Sort.SortCriteria.isSortCriteriaValid(orderSplitted[1])) {
			return false;
		}
		return true;
	}
}

