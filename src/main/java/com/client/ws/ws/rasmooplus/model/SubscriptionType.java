package com.client.ws.ws.rasmooplus.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)       // Para evitar que se chame o equals e o hashcode da classe RepresentationModel e use o do Lombok
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "subscriptions_type")
@Entity
public class SubscriptionType extends RepresentationModel<SubscriptionType> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriptions_type_id")
    private Long id;

    private String name;

    @Column(name = "access_months")
    private Long accessMonths;

    private BigDecimal price;

    @Column(name = "product_key", unique = true)
    private String productKey;

}

/*
RepresentationModel --> Faz a implementação do padrão HATEOAS no projeto.
 */