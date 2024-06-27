package com.invoice.discount.services;

import com.invoice.discount.DiscountDTO;
import com.invoice.discount.DiscountExternalAPI;
import com.invoice.discount.mappers.DiscountMapper;
import com.invoice.discount.models.Discount;
import com.invoice.discount.repositories.DiscountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@RequiredArgsConstructor // Para inyecciones opcionales
public class DiscountService implements DiscountExternalAPI {
    private DiscountRepository discountRepository;
    private DiscountMapper discountMapper;

    @Override
    public DiscountDTO getDiscountById(Long id) {
        return discountMapper.discountToDiscountDTO(
                discountRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("Discount not found with id: " + id))
        );
    }

    @Override
    public List<DiscountDTO> getAllDiscounts() {
        return discountRepository.findAll()
                .stream()
                .map(discount -> discountMapper.discountToDiscountDTO(discount))
                .toList();
    }
    @Transactional // Asegura que la operación de guardado está envuelta en una transacción
    @Override
    public DiscountDTO saveDiscount(DiscountDTO discountDTO) {
        return discountMapper.discountToDiscountDTO(
                discountRepository.save(discountMapper.discountDTOToDiscount(discountDTO)));
    }

    @Transactional
    @Override
    public DiscountDTO updateDiscount(Long id, DiscountDTO discountDTO) {
        Discount discount = discountMapper.discountDTOToDiscount(getDiscountById(id));
        discount.setName(discountDTO.name());
        discount.setDescription(discountDTO.description());
        discount.setType(discountDTO.type());
        discount.setPercentage(discountDTO.percentage());
        discount.setConditions(discountDTO.conditions());
        discount.setStartDate(discountDTO.startDate());
        discount.setEndDate(discountDTO.endDate());
        discount.setIsActive(discountDTO.isActive());
        return discountMapper.discountToDiscountDTO(discount);
    }

    @Transactional
    @Override
    public DiscountDTO deleteDiscount(Long id) {
        Discount discount = discountMapper.discountDTOToDiscount(getDiscountById(id));
        DiscountDTO discountDTO = discountMapper.discountToDiscountDTO(discount);
        discountRepository.delete(discount);
        return discountDTO;
    }
}
