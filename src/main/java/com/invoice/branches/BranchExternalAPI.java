package com.invoice.branches;

import java.util.List;

public interface BranchExternalAPI {
    BranchDTO getBranchById(Long id);
    List<BranchDTO> getAllBranches();
    BranchDTO saveBranch(BranchDTO branchDTO);
    BranchDTO updateBranch(Long id, BranchDTO branchDTO);
    BranchDTO deleteBranch(Long id);
}