package com.example.dev.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ContributionDto {
    private Long id;
    private Long userId;
    private Long articleId;
    private String type; 
    private LocalDate date;
    private String lieu;
}
