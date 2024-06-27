package com.invoice.branches.services;

import com.invoice.branches.BranchDTO;
import com.invoice.branches.BranchExternalAPI;
import com.invoice.branches.exceptions.BranchNotFoundException;
import com.invoice.branches.mappers.BranchMapper;
import com.invoice.branches.models.Branch;
import com.invoice.branches.repositories.BranchRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class BranchService implements BranchExternalAPI {
    private BranchRepository branchRepository;
    private BranchMapper branchMapper;

    @Override
    public BranchDTO getBranchById(Long id) {
        return branchMapper.branchToBranchDTO(branchRepository.findById(id).orElseThrow(BranchNotFoundException::new));
    }

    @Override
    public List<BranchDTO> getAllBranches() {
        return branchRepository.findAll()
                .stream()
                .map(branch -> branchMapper.branchToBranchDTO(branch))
                .toList();
    }

    @Transactional
    @Override
    public BranchDTO saveBranch(BranchDTO branchDTO) {
        return branchMapper.branchToBranchDTO(branchRepository.save(branchMapper.branchDTOToBranch(branchDTO)));
    }
    @Transactional
    @Override
    public BranchDTO updateBranch(Long id, BranchDTO branchDTO) {
        Branch branch = branchMapper.branchDTOToBranch(getBranchById(id));
        branch.setCompany_id(branchDTO.company_id());
        branch.setName(branchDTO.name());
        branch.setAddress(branchDTO.address());
        branch.setDescription(branchDTO.description());
        return branchMapper.branchToBranchDTO(branchRepository.save(branch));
    }
    @Transactional
    @Override
    public BranchDTO deleteBranch(Long id) {
        Branch branch = branchMapper.branchDTOToBranch(getBranchById(id));
        BranchDTO branchDTO = branchMapper.branchToBranchDTO(branch);
        branchRepository.delete(branch);
        return branchDTO;
    }
}