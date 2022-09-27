package com.client.ws.ws.rasmooplus.mapper;

import com.client.ws.ws.rasmooplus.dto.SubscriptionTypeDto;
import com.client.ws.ws.rasmooplus.exception.BadRequestException;
import com.client.ws.ws.rasmooplus.model.SubscriptionType;

import java.util.Objects;

public class SubscriptionTypeMapper {

    // O método fromDtoToEntity recebe um SubscriptionTypeDto e retorna um SubscriptionType, ou seja,
    // converte um SubscriptionTypeDto em um SubscriptionType para ser processado pelo Repository
    public static SubscriptionType fromDtoToEntity(SubscriptionTypeDto dto) {
        return SubscriptionType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .accessMonth(dto.getAccessMonth())
                .price(dto.getPrice())
                .productKey(dto.getProductKey())
                .build();
    }
}


/*
Faz o mapeamento de um DTO para uma entidade e vice-versa.
 */
