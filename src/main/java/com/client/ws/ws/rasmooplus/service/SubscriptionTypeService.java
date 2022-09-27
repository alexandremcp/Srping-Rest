package com.client.ws.ws.rasmooplus.service;

import com.client.ws.ws.rasmooplus.dto.SubscriptionTypeDto;
import com.client.ws.ws.rasmooplus.model.SubscriptionType;

import java.util.List;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();

    SubscriptionType findById(Long id);

    SubscriptionType create(SubscriptionTypeDto dto);

    SubscriptionType update(Long id, SubscriptionTypeDto dto);

    void delete(Long id);
}


/*
SERVICE - parte 2
=================
1 - O Service é a camada de negócio, onde é feita a lógica de negócio.
2 - O Service é uma interface, ou seja, um contrato, onde são definidos os métodos que serão implementados na classe de serviço,
    neste caso, SubscriptionTypeServiceImpl que implementa a interface SubscriptionTypeService.

Observações:
Utilizar preferencialmente List, Set ou Iterable, nunca usar ArrayList, pois,
é sempre melhor trabalhar com arquitetura voltada a interface e não a implementação.
 */
