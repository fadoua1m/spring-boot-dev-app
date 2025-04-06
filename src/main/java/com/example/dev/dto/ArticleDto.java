package com.example.dev.dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticleDto {
    private Long id;
    private String doi;
    private String titre;
    private List<String> motsCles;
    private Long domaineId;
}
