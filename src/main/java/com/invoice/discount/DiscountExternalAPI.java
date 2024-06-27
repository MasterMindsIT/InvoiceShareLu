package com.invoice.discount;

import java.util.List;

public interface DiscountExternalAPI {
    DiscountDTO getDiscountById(Long id);
    List<DiscountDTO> getAllDiscounts();
    DiscountDTO saveDiscount(DiscountDTO discountDTO);
    DiscountDTO updateDiscount(Long id, DiscountDTO discountDTO);
    DiscountDTO deleteDiscount(Long id);
}