package com.crs.controller;

import com.crs.dto.ApiResponse;
import com.crs.dto.branch.AddBranchDTO;
import com.crs.dto.branch.GetBranchDTO;
import com.crs.dto.branch.UpdateBranchDTO;
import com.crs.dto.car.GetCarDTO;
import com.crs.service.BranchService;
import com.crs.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllBranch() {

        List<GetBranchDTO> branchDTOList = branchService.getBranches();

        if (branchDTOList == null) {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse(false, "Data not found!"));
        }

        return ResponseEntity.status(HttpStatus.OK).body(branchDTOList);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBranch(@RequestBody AddBranchDTO request) {

        AddBranchDTO branchDTO = branchService.addBranch(request);

        if (branchDTO == null) {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse(false, "Branch not added!"));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "Branch added successfully!"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBranch(@RequestBody UpdateBranchDTO request) {

        UpdateBranchDTO branchDTO = branchService.updateBranch(request);

        if (branchDTO == null) {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse(false, "Branch not updated or found!"));
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse(true, "Branch updated successfully!"));
    }

    @GetMapping("/{branch_id}/cars")
    public ResponseEntity<?> getCarByBranch(@PathVariable("branch_id") Long branch_id) {

        List<GetCarDTO> carDTOList = carService.getCarByBranch(branch_id);

        if (carDTOList == null) {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse(false, "Data not found!"));
        }

        return ResponseEntity.status(HttpStatus.OK).body(carDTOList);
    }
}
