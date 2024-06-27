package com.invoice.gateway;

import com.invoice.branches.BranchDTO;
import com.invoice.branches.BranchExternalAPI;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchController {
    private BranchExternalAPI branchExternalAPI;
    public BranchController(BranchExternalAPI branchExternalAPI) {
        this.branchExternalAPI = branchExternalAPI;
    }

    @GetMapping("/{id}")
    public BranchDTO findById(@PathVariable("id") Long id){
        return branchExternalAPI.getBranchById(id);
    }
    @GetMapping
    public List<BranchDTO> all(){
        return branchExternalAPI.getAllBranches();
    }
    @PostMapping
    public BranchDTO save(@RequestBody @Valid BranchDTO branchDTO){
        return branchExternalAPI.saveBranch(branchDTO);
    }
    @PutMapping("{id}")
    public BranchDTO update(@PathVariable("id") Long id, @RequestBody BranchDTO branchDTO){
        return branchExternalAPI.updateBranch(id, branchDTO);
    };
    @DeleteMapping("{id}")
    public BranchDTO delete(@PathVariable("id") Long id){
        return branchExternalAPI.deleteBranch(id);
    }
}