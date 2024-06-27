package com.invoice.taxes.repositories;

import com.invoice.taxes.models.Taxes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxesRepository extends JpaRepository<Taxes, Long> {
}