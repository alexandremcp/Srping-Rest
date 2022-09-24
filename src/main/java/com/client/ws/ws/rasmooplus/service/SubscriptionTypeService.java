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
Observações:
Utilizar preferencialmente List, Set ou Iterable, nunca usar ArrayList, pois,
é sempre melhor trabalhar com arquitetura voltada a interface e não a implementação.
 */
