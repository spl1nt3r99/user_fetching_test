package com.denys.multiple_users.service;

import com.denys.multiple_users.dto.UserDto;
import com.denys.multiple_users.dto.UserFilterDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers(UserFilterDto filterDto);
}
