package com.invoice.inventories.services;

import com.invoice.inventories.InventoryDTO;
import com.invoice.inventories.exceptions.ResourceNotFoundException;
import com.invoice.inventories.models.Inventory;
import com.invoice.inventories.InventoryExternalAPI;
import com.invoice.inventories.mappers.InventoryMapper;
import com.invoice.inventories.repositories.InventoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class InventoryService implements InventoryExternalAPI {

    private InventoryRepository inventoryRepository;
    private InventoryMapper inventoryMapper;
    @Override
    public InventoryDTO getInventoryById(Long id) {
        return inventoryRepository.findById(id)
                .map(inventoryMapper::inventoryToInventoryDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id: " + id));
    }

    @Override
    public List<InventoryDTO> getAllInventories() {
        return inventoryRepository.findAll().stream()
                .map(inventoryMapper::inventoryToInventoryDTO)
                .toList();
    }

    @Transactional
    @Override
    public InventoryDTO saveInventory(InventoryDTO inventoryDTO) {
        return inventoryMapper.inventoryToInventoryDTO(
                inventoryRepository.save(inventoryMapper.inventoryDTOToInventory(inventoryDTO)));
    }
    @Transactional
    @Override
    public InventoryDTO updateInventory(Long id, InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryMapper.inventoryDTOToInventory(getInventoryById(id));
        inventory.setUserId(inventoryDTO.userId());
        inventory.setDescription(inventoryDTO.description());
        inventory.setProductId(inventoryDTO.productId());
        inventory.setSucursalId(inventoryDTO.sucursalId());
        inventory.setReasonId(inventoryDTO.reasonId());
        inventory.setAdjust(inventoryDTO.adjust());
        inventory.setDescription(inventoryDTO.description());
        inventory.setQuantity(inventoryDTO.quantity());
        inventory.setLocation(inventoryDTO.location());
        inventory.setReorderLevel(inventoryDTO.reorderLevel());
        inventory.setLastUpdated(inventoryDTO.lastUpdated());
        return inventoryMapper.inventoryToInventoryDTO(inventory);
    }

    @Transactional
    @Override
    public InventoryDTO deleteInventory(Long id) {
        Inventory inventory = inventoryMapper.inventoryDTOToInventory(getInventoryById(id));
        InventoryDTO inventoryDTO = inventoryMapper.inventoryToInventoryDTO(inventory);
        inventoryRepository.delete(inventory);
        return inventoryDTO;
    }
}