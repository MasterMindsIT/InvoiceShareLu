package com.invoice.providers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<com.invoice.providers.models.Provider, Long> {
}
