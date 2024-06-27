package com.invoice.discount.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del descuento
    private String name;

    // Descripción del descuento
    private String description;

    // Tipo de descuento (por ejemplo, porcentaje o fijo)
    private String type;

    // Porcentaje del descuento si es aplicable
    private BigDecimal percentage;

    // Condiciones específicas para el uso del descuento
    private String conditions;

    // Fecha de inicio del descuento
    private ZonedDateTime startDate;

    // Fecha de fin del descuento
    private ZonedDateTime endDate;

    // Estado del descuento (activo/inactivo)
    private Boolean isActive;

    // Relación con otros elementos como facturas o productos
    /*@OneToMany(mappedBy = "discount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices;*/

    // Relación con impuestos si aplica
    /*@ManyToMany
    @JoinTable(
            name = "discount_taxes",
            joinColumns = @JoinColumn(name = "discount_id"),
            inverseJoinColumns = @JoinColumn(name = "taxes_id")
    )
    private List<Taxes> taxes;*/
}