package com.example.dev.controller;

import com.example.dev.dto.ContributionDto;
import com.example.dev.service.ContributionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contributions")
@RequiredArgsConstructor
public class ContributionController {

    private final ContributionService contributionService;

    @GetMapping
    public ResponseEntity<List<ContributionDto>> getAllContributions() {
        return ResponseEntity.ok(contributionService.getAllContributions());
    }

    @PostMapping
    public ResponseEntity<ContributionDto> assignContribution(
             @RequestBody ContributionDto dto) {
        return new ResponseEntity<>(
                contributionService.assignContribution(dto), 
                HttpStatus.CREATED);
    }
}