package com.example.dev.service.impl;

import com.example.dev.dto.*;
import com.example.dev.model.*;
import com.example.dev.repository.*;
import com.example.dev.service.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContributionServiceImpl implements ContributionService {

    @Autowired
    private ContributionRepository contributionRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public ContributionDto assignContribution(ContributionDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        Article article = articleRepository.findById(dto.getArticleId())
                .orElseThrow(() -> new RuntimeException("Article not found"));
        
        Contribution contribution = new Contribution();
        contribution.setType(dto.getType());
        contribution.setLieu(dto.getLieu());
        contribution.setUser(user);
        contribution.setArticle(article);
        
        Contribution savedContribution = contributionRepository.save(contribution);
        return mapToDto(savedContribution);
    }

    @Override
    public List<ContributionDto> getAllContributions() {
        return contributionRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private ContributionDto mapToDto(Contribution contribution) {
        ContributionDto dto = new ContributionDto();
        dto.setId(contribution.getId());
        dto.setUserId(contribution.getUser().getId());
        dto.setArticleId(contribution.getArticle().getId());
        dto.setType(contribution.getType());
        dto.setLieu(contribution.getLieu());
        return dto;
    }
}