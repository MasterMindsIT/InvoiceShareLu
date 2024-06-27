package com.invoice.providers;

import com.invoice.providers.ProviderDTO;

import java.util.List;

public interface ProviderExternalAPI {
    ProviderDTO getProviderById(Long id);
    List<ProviderDTO> getAllProvider();
    ProviderDTO saveProvider(ProviderDTO providerDTO);

    ProviderDTO updateProvider(Long id, ProviderDTO providerDTO);

    ProviderDTO deleteProvider(Long id);
}
