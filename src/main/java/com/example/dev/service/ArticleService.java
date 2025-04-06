package com.example.dev.service;

import com.example.dev.dto.*;
import java.util.List;

public interface ArticleService {
    ArticleDto createArticle(CreateArticleDto dto);
    List<ArticleDto> getAllArticles();
    ArticleDto updateArticle(Long id, CreateArticleDto dto);
    void deleteArticle(Long id);
    List<ArticleDto> searchArticlesByKeyword(String keyword);
}

