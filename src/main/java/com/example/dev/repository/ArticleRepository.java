package com.example.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitreContainingIgnoreCase(String motclé);
}
