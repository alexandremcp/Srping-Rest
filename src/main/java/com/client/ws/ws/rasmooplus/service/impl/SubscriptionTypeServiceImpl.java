package com.client.ws.ws.rasmooplus.service.impl;

import com.client.ws.ws.rasmooplus.model.SubscriptionType;
import com.client.ws.ws.rasmooplus.repository.SubscriptionTypeRepository;
import com.client.ws.ws.rasmooplus.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

    // Faz a injeção de dependência
    private final SubscriptionTypeRepository subscriptionTypeRepository;

    // Inicializa a injeção de dependência
    SubscriptionTypeServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    @Override
    public List<SubscriptionType> findAll() {
        return subscriptionTypeRepository.findAll();    // Retorna a lista de SubscriptionType
    }

    @Override
    public SubscriptionType findById(Long id) {
        return null;
    }

    @Override
    public SubscriptionType create(SubscriptionType subscriptionType) {
        return null;
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionType subscriptionType) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
