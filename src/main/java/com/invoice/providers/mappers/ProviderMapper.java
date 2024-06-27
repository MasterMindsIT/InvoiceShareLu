package com.invoice.providers.mappers;

import com.invoice.providers.ProviderDTO;
import com.invoice.providers.models.Provider;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProviderMapper {
    ProviderMapper INSTANCE = Mappers.getMapper(ProviderMapper.class);
    ProviderDTO providerToProviderDTO(Provider provider);
    Provider ProviderDTOToProvider(ProviderDTO providerDTO);
}
