package com.example.usermanageapirest.application.controller.user.response;

import com.example.usermanageapirest.builder.Builder;

class PageResponseBuilder extends Builder<PageResponse> {

	@Override
	public PageResponse build(int index) {
		return new PageResponse()
			.setPage(2+index)
			.setSize(10+index)
			.setTotalElements(20+index)
			.setTotalPages(2+index);
	}
}