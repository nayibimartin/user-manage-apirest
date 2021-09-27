package com.example.usermanageapirest.application.controller.user.response;

import com.example.usermanageapirest.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PageResponseCreator {

	public PageResponse create(Page<User> userPage){
		return new PageResponse()
			.setPage(userPage.getNumber())
			.setTotalPages(userPage.getTotalPages())
			.setTotalElements(userPage.getNumberOfElements())
			.setSize(userPage.getSize());
	}

}
