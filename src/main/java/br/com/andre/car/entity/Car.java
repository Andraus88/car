package br.com.andre.car.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARRO")
public class Car {

    @Id
    private Long idChassi;

    private String name;

    private String brand;

    private String color;

    private String fabricationYear;

}
