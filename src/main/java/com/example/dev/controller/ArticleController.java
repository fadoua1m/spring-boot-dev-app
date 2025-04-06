package com.example.dev.controller;

import com.example.dev.dto.ArticleDto;
import com.example.dev.dto.CreateArticleDto;
import com.example.dev.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<ArticleDto>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ArticleDto>> searchArticles(
            @RequestParam String keyword) {
        return ResponseEntity.ok(articleService.searchArticlesByKeyword(keyword));
    }

    @PostMapping
    public ResponseEntity<ArticleDto> createArticle(
            @RequestBody CreateArticleDto dto) {
        return new ResponseEntity<>(articleService.createArticle(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDto> updateArticle(
            @PathVariable Long id,
             @RequestBody CreateArticleDto dto) {
        return ResponseEntity.ok(articleService.updateArticle(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}