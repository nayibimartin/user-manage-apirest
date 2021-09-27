package com.example.usermanageapirest.application.controller.user.response;

import com.example.usermanageapirest.builder.Builder;
import com.example.usermanageapirest.domain.entity.User;
import com.example.usermanageapirest.domain.entity.UserBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class PageBuilder extends Builder<Page> {
	@Override
	public Page<User> build(int index) {
		return new Page() {
			@Override
			public int getTotalPages() {
				return 2 + index;
			}

			@Override
			public long getTotalElements() {
				return 0;
			}

			@Override
			public Page map(Function function) {
				return null;
			}

			@Override
			public int getNumber() {
				return 2+index;
			}

			@Override
			public int getSize() {
				return 10 + index;
			}

			@Override
			public int getNumberOfElements() {
				return 20 + index;
			}

			@Override
			public List getContent() {
				return new UserBuilder().buildList(index);
			}

			@Override
			public boolean hasContent() {
				return false;
			}

			@Override
			public Sort getSort() {
				return null;
			}

			@Override
			public boolean isFirst() {
				return false;
			}

			@Override
			public boolean isLast() {
				return false;
			}

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public boolean hasPrevious() {
				return false;
			}

			@Override
			public Pageable nextPageable() {
				return null;
			}

			@Override
			public Pageable previousPageable() {
				return null;
			}

			@Override
			public Iterator iterator() {
				return null;
			}
		};

	}
}
