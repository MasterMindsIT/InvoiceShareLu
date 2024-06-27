package com.invoice.taxes.models;


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
public class Taxes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del impuesto
    private String name;

    // Valor del impuesto
    private Double value;

    // Descripción del impuesto
    private String description;

    // Estado del impuesto (activo/inactivo)
    private Boolean isActive;

    // Relación con descuentos si aplica
   /* @OneToMany(mappedBy = "taxes_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Discount> discounts;*/
}