package com.sebas.personas.model;

import jakarta.persistence.*;

@Entity
@Table
public class Personas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dni;

    @Column
    private String name;

    public Long getId() {
        return id;
    }
}
