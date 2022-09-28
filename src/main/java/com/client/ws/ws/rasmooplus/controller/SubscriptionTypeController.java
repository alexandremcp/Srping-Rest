package com.client.ws.ws.rasmooplus.controller;

import com.client.ws.ws.rasmooplus.dto.SubscriptionTypeDto;
import com.client.ws.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.ws.rasmooplus.model.SubscriptionType;
import com.client.ws.ws.rasmooplus.repository.SubscriptionTypeRepository;
import com.client.ws.ws.rasmooplus.service.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/subscription-type")
public class SubscriptionTypeController {

    @Autowired
    private SubscriptionTypeService subscriptionTypeService;

    @GetMapping
    public ResponseEntity<List<SubscriptionType>> findAll() {     // 1º Criado o responseEntity de pesquisa
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable("id") Long id) {
            return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SubscriptionType> create(@Valid @RequestBody SubscriptionTypeDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionType> create(@PathVariable("id") Long id, @RequestBody SubscriptionTypeDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        subscriptionTypeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}

/*
CONTROLLER - parte 1
=====================
1 - O controller recebe os dados vindos do front-end no formato JSON, e faz as validações.
2 - O controller converte os dados recebidos numa classe de modelo (model), que representa uma tabela no banco de dados,
    neste caso, SubscriptionType -->  ResponseEntity<SubscriptionType>
3 - O controller chama o service, que é a camada de negócio, onde é feita a lógica de negócio.
4 - O controle por fim retorna os dados para o front-end no formato JSON.

O controller também Serve para que o Spring saiba onde encontrar o mapeamento de cada método quando feito o acesso pela URL no navegador,
    como por exemplo o @GetMapping("/{id}")


@Valid --> faz a validação dos dados vindos do front-end, conforme as anotações feitas na classe SubscriptionTypeDto
 */
