package com.client.ws.ws.rasmooplus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionTypeDto {

    private Long id;
    private String name;
    private Long accessMonth;
    private BigDecimal price;
    private String productKey;

}

/*
A classe SubscriptionTypeDto é responsável por representar os dados de um SubscriptionType.
A classe faz o mapeamento de um DTO para uma entidade e vice-versa.
 */
