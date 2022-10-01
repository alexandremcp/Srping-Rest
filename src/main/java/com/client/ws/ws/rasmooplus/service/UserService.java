package com.client.ws.ws.rasmooplus.service;

import com.client.ws.ws.rasmooplus.dto.UserDto;
import com.client.ws.ws.rasmooplus.model.User;

public interface UserService {

    User create(UserDto dto);
}
