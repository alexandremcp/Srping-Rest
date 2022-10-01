package com.client.ws.ws.rasmooplus.mapper;

import com.client.ws.ws.rasmooplus.dto.UserDto;
import com.client.ws.ws.rasmooplus.model.SubscriptionType;
import com.client.ws.ws.rasmooplus.model.User;
import com.client.ws.ws.rasmooplus.model.UserType;

public class UserMapper {

    public static User fromDtoToEntity(UserDto dto, UserType userType, SubscriptionType subscriptionType) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .cpf(dto.getCpf())
                .dtSubscription(dto.getDtSubscription())
                .dtExpiration(dto.getDtExpiration())
                .userType(userType)
                .subscriptionType(subscriptionType)
                .build();
    }
}

/*
Esta classe é responsável por mapear os dados do DTO para a entidade User.
Ela recebe como parâmetro o DTO, o UserType e o SubscriptionType.
Ela retorna um objeto User.
 */
