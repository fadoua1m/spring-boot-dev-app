package com.example.dev.service;

import com.example.dev.dto.ContributionDto;

import java.util.List;

public interface ContributionService {
    ContributionDto assignContribution(ContributionDto dto);
    List<ContributionDto> getAllContributions();
}
