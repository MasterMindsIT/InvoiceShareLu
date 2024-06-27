package com.invoice.gateway;

import com.invoice.taxes.TaxesDTO;
import com.invoice.taxes.TaxesExternalAPI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("taxes")
public class TaxesController {
    private TaxesExternalAPI taxesExternalAPI;

    public TaxesController(TaxesExternalAPI taxesExternalAPI) {
        this.taxesExternalAPI = taxesExternalAPI;
    }
    @GetMapping("/{id}")
    public TaxesDTO findById(@PathVariable("id")Long id){
        return taxesExternalAPI.getTaxesById(id);
    }
    @GetMapping
    public List<TaxesDTO> allTaxes(){
        return taxesExternalAPI.getAllTaxes();
    }
    @PostMapping
    public TaxesDTO saveTaxes(@RequestBody TaxesDTO taxesDTO){
        return taxesExternalAPI.saveTaxes(taxesDTO);
    }
    @PutMapping("/{id}")
    public TaxesDTO updateTaxes(@PathVariable("id") Long id, TaxesDTO taxesDTO){
        return taxesExternalAPI.updateTaxes(id, taxesDTO);
    }
    @DeleteMapping("/{id}")
    public TaxesDTO deleteTaxes(@PathVariable("id") Long id){
        return taxesExternalAPI.deleteTaxes(id);
    }
}