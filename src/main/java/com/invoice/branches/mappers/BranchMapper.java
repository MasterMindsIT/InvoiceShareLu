package com.invoice.branches.mappers;

import com.invoice.branches.BranchDTO;
import com.invoice.branches.models.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BranchMapper {
    BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class);
    BranchDTO branchToBranchDTO(Branch branch);
    Branch branchDTOToBranch(BranchDTO branchDTO);
}