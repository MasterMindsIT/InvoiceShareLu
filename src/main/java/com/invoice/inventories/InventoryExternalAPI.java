package com.invoice.inventories;

import java.util.List;

public interface InventoryExternalAPI {
    InventoryDTO getInventoryById(Long id);
    List<InventoryDTO> getAllInventories();
    InventoryDTO saveInventory(InventoryDTO inventoryDTO);
    InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO);
    InventoryDTO deleteInventory(Long id);
}