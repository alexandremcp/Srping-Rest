package com.client.ws.ws.rasmooplus.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_type")
public class UserType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_type_id")
    private long id;

    private String name;

    private String description;
}
