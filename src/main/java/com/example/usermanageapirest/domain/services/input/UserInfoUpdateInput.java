package com.example.usermanageapirest.domain.services.input;

import com.example.usermanageapirest.domain.entity.User;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UserInfoUpdateInput {

	private User user;
	private UserUpdateInput userUpdateInput;

}
