package com.invoice.inventories.mappers;

import com.invoice.inventories.InventoryDTO;
import com.invoice.inventories.models.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);
    InventoryDTO inventoryToInventoryDTO(Inventory inventory);
    Inventory inventoryDTOToInventory(InventoryDTO inventoryDTO);
}