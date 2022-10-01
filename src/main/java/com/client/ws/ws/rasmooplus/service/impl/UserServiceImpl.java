package com.client.ws.ws.rasmooplus.service.impl;

import com.client.ws.ws.rasmooplus.dto.UserDto;
import com.client.ws.ws.rasmooplus.exception.BadRequestException;
import com.client.ws.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.ws.rasmooplus.mapper.UserMapper;
import com.client.ws.ws.rasmooplus.model.User;
import com.client.ws.ws.rasmooplus.model.UserType;
import com.client.ws.ws.rasmooplus.repository.UserRepository;
import com.client.ws.ws.rasmooplus.repository.UserTypeRepository;
import com.client.ws.ws.rasmooplus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserTypeRepository userTypeRepository;

    UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public User create(UserDto dto) {

        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("Id deve ser nulo");
        }

        var userTypeOpt = userTypeRepository.findById(dto.getUserTypeId());

        if (userTypeOpt.isEmpty()) {
            throw new NotFoundException("UserType não encontrado");
        }

        UserType userType = userTypeOpt.get();
        User user = UserMapper.fromDtoToEntity(dto, userType, null);
        return userRepository.save(user);
    }
}
