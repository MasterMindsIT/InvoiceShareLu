package com.invoice.gateway;

import com.invoice.discount.DiscountDTO;
import com.invoice.discount.DiscountExternalAPI;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/discounts")
public class DiscountsController {
    private final DiscountExternalAPI discountExternalAPI;

    public DiscountsController(DiscountExternalAPI discountExternalAPI) {
        this.discountExternalAPI = discountExternalAPI;
    }

    @GetMapping("/{id}")
    public DiscountDTO findById(@PathVariable("id") Long id) {
        return discountExternalAPI.getDiscountById(id);
    }

    @GetMapping
    public List<DiscountDTO> getAllDiscounts() {
        return discountExternalAPI.getAllDiscounts();
    }

    @PostMapping
    public DiscountDTO saveDiscount(@RequestBody DiscountDTO discountDTO) {
        return discountExternalAPI.saveDiscount(discountDTO);
    }

    @PutMapping("/{id}")
    public DiscountDTO updateDiscount(@PathVariable("id") Long id, @RequestBody DiscountDTO discountDTO) {
        return discountExternalAPI.updateDiscount(id, discountDTO);
    }

    @DeleteMapping("/{id}")
    public DiscountDTO deleteDiscount(@PathVariable("id") Long id) {
        return discountExternalAPI.deleteDiscount(id);
    }
}