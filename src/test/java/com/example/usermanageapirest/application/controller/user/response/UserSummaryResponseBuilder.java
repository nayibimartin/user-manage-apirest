package com.example.usermanageapirest.application.controller.user.response;

import com.example.usermanageapirest.builder.Builder;

class UserSummaryResponseBuilder extends Builder<UserSummaryResponse> {

	@Override
	public UserSummaryResponse build(int index) {
		return new UserSummaryResponse().setUser(new UserDetailsResponseBuilder().build(1));
	}

}