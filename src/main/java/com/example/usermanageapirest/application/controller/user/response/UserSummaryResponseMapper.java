package com.example.usermanageapirest.application.controller.user.response;

import com.example.usermanageapirest.application.user.Mapper;
import com.example.usermanageapirest.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSummaryResponseMapper implements Mapper<User, UserSummaryResponse> {

	private Mapper<User, UserDetailsResponse> userDetailsResponseMapper;

	@Autowired
	public UserSummaryResponseMapper(Mapper<User, UserDetailsResponse> userDetailsResponseMapper) {
		this.userDetailsResponseMapper = userDetailsResponseMapper;
	}

	@Override
	public UserSummaryResponse map(User user) {
		return new UserSummaryResponse()
			.setUser(this.userDetailsResponseMapper.map(user));
	}

}
