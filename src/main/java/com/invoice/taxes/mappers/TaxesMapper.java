package com.invoice.taxes.mappers;

import com.invoice.taxes.TaxesDTO;
import com.invoice.taxes.models.Taxes;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaxesMapper {
    TaxesMapper INSTANCE = Mappers.getMapper(TaxesMapper.class);
    TaxesDTO taxesToTaxesDTO(Taxes taxes);
    Taxes taxesDTOToTaxes(TaxesDTO taxesDTO);
}
