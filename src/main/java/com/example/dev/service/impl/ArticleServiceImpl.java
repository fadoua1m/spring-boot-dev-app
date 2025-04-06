package com.example.dev.service.impl;

import com.example.dev.dto.*;
import com.example.dev.model.*;
import com.example.dev.repository.*;
import com.example.dev.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private DomaineRepository domaineRepository;

    @Override
    public ArticleDto createArticle(CreateArticleDto dto) {
        Domaine domaine = domaineRepository.findById(dto.getDomaineId())
                .orElseThrow(() -> new RuntimeException("Domaine not found"));
        
        Article article = new Article();
        article.setDoi(dto.getDoi());
        article.setTitre(dto.getTitre());
        article.setMotsCles(String.join(",", dto.getMotsCles()));
        article.setDomaine(domaine);
        
        Article savedArticle = articleRepository.save(article);
        return mapToDto(savedArticle);
    }

    @Override
    public List<ArticleDto> getAllArticles() {
        return articleRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDto updateArticle(Long id, CreateArticleDto dto) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        
        Domaine domaine = domaineRepository.findById(dto.getDomaineId())
                .orElseThrow(() -> new RuntimeException("Domaine not found"));
        
        article.setDoi(dto.getDoi());
        article.setTitre(dto.getTitre());
        article.setMotsCles(String.join(",", dto.getMotsCles()));
        article.setDomaine(domaine);
        
        Article updatedArticle = articleRepository.save(article);
        return mapToDto(updatedArticle);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<ArticleDto> searchArticlesByKeyword(String keyword) {
        return articleRepository.findByTitreContainingIgnoreCase(keyword).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private ArticleDto mapToDto(Article article) {
        ArticleDto dto = new ArticleDto();
        dto.setId(article.getId());
        dto.setDoi(article.getDoi());
        dto.setTitre(article.getTitre());
        dto.setMotsCles(List.of(article.getMotsCles().split(",")));
        dto.setDomaineId(article.getDomaine().getId());
        return dto;
    }
}
