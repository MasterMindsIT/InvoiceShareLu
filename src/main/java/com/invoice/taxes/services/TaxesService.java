package com.invoice.taxes.services;

import com.invoice.taxes.TaxesDTO;
import com.invoice.taxes.TaxesExternalAPI;
import com.invoice.taxes.mappers.TaxesMapper;
import com.invoice.taxes.models.Taxes;
import com.invoice.taxes.repositories.TaxesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class TaxesService implements TaxesExternalAPI {
    private TaxesRepository taxesRepository;
    private TaxesMapper taxesMapper;

    @Override
    public TaxesDTO getTaxesById(Long id) {
        return taxesMapper.taxesToTaxesDTO(
                taxesRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Taxes not found with id: " + id))
        );
    }

    @Override
    public List<TaxesDTO> getAllTaxes() {
        return taxesRepository.findAll()
                .stream()
                .map(taxes -> taxesMapper.taxesToTaxesDTO(taxes))
                .toList();
    }

    @Transactional
    @Override
    public TaxesDTO saveTaxes(TaxesDTO taxesDTO) {
        return taxesMapper.taxesToTaxesDTO(taxesRepository.save(taxesMapper.taxesDTOToTaxes(taxesDTO)));
    }

    @Transactional
    @Override
    public TaxesDTO updateTaxes(Long id, TaxesDTO taxesDTO) {
        Taxes taxes = taxesMapper.taxesDTOToTaxes(getTaxesById(id));
        taxes.setName(taxesDTO.name());
        taxes.setValue(taxesDTO.value());
        taxes.setDescription(taxesDTO.description());
        taxes.setIsActive(taxesDTO.isActive());
        return taxesMapper.taxesToTaxesDTO(taxesRepository.save(taxes));
    }

    @Transactional
    @Override
    public TaxesDTO deleteTaxes(Long id) {
        Taxes taxes = taxesMapper.taxesDTOToTaxes(getTaxesById(id));
        TaxesDTO taxesDTO = taxesMapper.taxesToTaxesDTO(taxes);
        taxesRepository.delete(taxes);
        return taxesDTO;
    }
}
