package com.invoice.inventories.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.ZonedDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "sucursal_id", nullable = false)
    private Long sucursalId;

    @Column(name = "reason_id", nullable = false)
    private Long reasonId;

    @Column(nullable = false)
    private Integer adjust;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = true)
    private String location;

    @Column(nullable = true)  // Consider using a dedicated data type for the reorder level if it is an important concept
    private Integer reorderLevel;

    @Column(nullable = true)
    private ZonedDateTime lastUpdated;
}