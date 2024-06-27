package com.invoice.taxes;

import java.util.List;

public interface TaxesExternalAPI {
    TaxesDTO getTaxesById(Long id);
    List<TaxesDTO> getAllTaxes();
    TaxesDTO saveTaxes(TaxesDTO TaxesDTO);
    TaxesDTO updateTaxes(Long id, TaxesDTO TaxesDTO);
    TaxesDTO deleteTaxes(Long id);
}
