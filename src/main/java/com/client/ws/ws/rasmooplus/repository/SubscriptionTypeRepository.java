package com.client.ws.ws.rasmooplus.repository;

import com.client.ws.ws.rasmooplus.model.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionType, Long> {

}

/*
REPOSITORY - parte 4
====================
1 - O repository é a camada de acesso a dados, onde é feita a comunicação com o banco de dados.
2 - O respository estende a interface JpaRepository, que é uma interface do Spring Data JPA,
    onde estão definidos os métodos padrões de acesso a dados como: save, delete, findById, findAll, etc.
3 - O repository então faz a comunicação com o banco de dados, através do Spring Data JPA, onde é feito o procesamento dos dados.
4 - O respository por fim retorna os dados para o Service, que por sua vez retorna os dados para o Controller.
*/
