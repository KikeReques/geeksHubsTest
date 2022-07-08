package com.geekshubs.kikereques.geekshubsTest.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "categoriaId")
    @NotEmpty
    private int categoryId;

    @Column(name = "nombre")
    @NotEmpty
    private String name;

    @Column(name = "precio")
    @NotEmpty
    private float price;

    @Column(name = "cantidad")
    @NotEmpty
    private int amount;


    private static final long serialVersionUID = 1L;
}
