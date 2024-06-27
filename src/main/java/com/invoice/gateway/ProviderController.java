package com.invoice.gateway;

import com.invoice.providers.ProviderDTO;
import com.invoice.providers.ProviderExternalAPI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
public class ProviderController {
    private ProviderExternalAPI providerExternalAPI;

    public ProviderController(ProviderExternalAPI providerExternalAPI) {
        this.providerExternalAPI = providerExternalAPI;
    }

    @GetMapping("/{id}")
    public ProviderDTO findById(@PathVariable("id") Long id){
        return providerExternalAPI.getProviderById(id);
    }
    @GetMapping
    public List<ProviderDTO> all(){
        return providerExternalAPI.getAllProvider();
    }
    @PostMapping
    public ProviderDTO save(@RequestBody ProviderDTO providerDTO){
        return providerExternalAPI.saveProvider(providerDTO);
    }
    @PutMapping("/{id}")
    public ProviderDTO update(@PathVariable("id")Long id, ProviderDTO providerDTO){
        return providerExternalAPI.updateProvider(id, providerDTO);
    }
    @DeleteMapping("/{id}")
    public ProviderDTO delete(@PathVariable("id") Long id){
        return providerExternalAPI.deleteProvider(id);
    }

}
