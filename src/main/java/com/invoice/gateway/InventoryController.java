package com.invoice.gateway;

import com.invoice.inventories.InventoryDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.invoice.inventories.InventoryExternalAPI;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private InventoryExternalAPI inventoryExternalAPI;
    public InventoryController(InventoryExternalAPI inventoryExternalAPI) {
        this.inventoryExternalAPI = inventoryExternalAPI;
    }
    @GetMapping("/{id}")
    public InventoryDTO findById(@PathVariable("id") Long id){
        return inventoryExternalAPI.getInventoryById(id);
    }
    @GetMapping
    public List<InventoryDTO> all(){
        return inventoryExternalAPI.getAllInventories();
    }
    @PostMapping
    public InventoryDTO save(@RequestBody InventoryDTO inventoryDTO){
        return inventoryExternalAPI.saveInventory(inventoryDTO);
    }
    @PutMapping("{id}")
    public InventoryDTO update(@PathVariable("id") Long id, @RequestBody InventoryDTO inventoryDTO){
        return inventoryExternalAPI.updateInventory(id, inventoryDTO);
    }
    @DeleteMapping("{id}")
    public InventoryDTO delete(@PathVariable("id") Long id){
        return inventoryExternalAPI.deleteInventory(id);
    }
}