package com.invoice.companies.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del descuento
    private String name;
    private String category;
    private String rut;
    private Integer user_id; // Asociado con el usuario
    private Integer taxes_id; // Asociado con los impuestos
}