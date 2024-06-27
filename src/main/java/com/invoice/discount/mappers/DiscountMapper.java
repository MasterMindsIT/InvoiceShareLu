package com.invoice.discount.mappers;

import com.invoice.discount.DiscountDTO;
import com.invoice.discount.models.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiscountMapper {
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);
    DiscountDTO discountToDiscountDTO(Discount discount);
    Discount discountDTOToDiscount(DiscountDTO discountDTO);
}
