package com.client.ws.ws.rasmooplus.service.impl;

import com.client.ws.ws.rasmooplus.dto.SubscriptionTypeDto;
import com.client.ws.ws.rasmooplus.exception.BadRequestException;
import com.client.ws.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.ws.rasmooplus.mapper.SubscriptionTypeMapper;
import com.client.ws.ws.rasmooplus.model.SubscriptionType;
import com.client.ws.ws.rasmooplus.repository.SubscriptionTypeRepository;
import com.client.ws.ws.rasmooplus.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.prefs.BackingStoreException;

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
        return getSubscriptionType(id);
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDto dto) {
        if (Objects.nonNull(dto.getId())) {                          //Se o ID é não for nulo lança uma exceção, pois, não pode ser criado um novo SubscriptionType com um ID existente
            throw new BadRequestException("Id deve ser nulo");      //Chama a exceção BadRequestException configurada no ResourceHandler
        }
        return subscriptionTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDto dto) {
        getSubscriptionType(id);   //Chama o método getSubscriptionType para verificar se o id existe
        dto.setId(id);             //Seta o id no dto
        return subscriptionTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        getSubscriptionType(id);   //Chama o método getSubscriptionType para verificar se o id existe
        subscriptionTypeRepository.deleteById(id);
    }


    // Essa parte foi extraída do findById e transformada em um método para ser reutilizado para ser
    // usada pelo update e pelo delete
    private SubscriptionType getSubscriptionType(Long id) {
        Optional<SubscriptionType> optionalSubscriptionType = subscriptionTypeRepository.findById(id);
        if (optionalSubscriptionType.isEmpty()) {
            throw new NotFoundException("SubscriptionType não encontrado");
        }
        return optionalSubscriptionType.get();
    }
}
/*
SERVICE IMPL - parte 3
======================
1 - O ServiceImpl é a implementação da interface Service, que representa a lógica de negócio
    --> SubscriptionTypeServiceImpl implements SubscriptionTypeService
2 - O ServiceImpl é uma classe, onde são implementados os métodos da interface SubscriptionTypeService.
3 - O ServiceImpl faz a injeção de dependência do Repository, para onde passa os dados do modelo, neste caso, SubscriptionType.
4 - O ServiceImpl tem por padrão a chamada dos métodos implementados na interface JpaRepository, que são os métodos padrões de CRUD como:
    --> findAll()
    --> findById()
    --> save()
    --> deleteById()
5 - O ServiceImpl por fim retorna os dados para o Controller.
*/
