package com.example.dev.controller;

import com.example.dev.dto.DomaineDto;
import com.example.dev.service.DomaineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/domaines")
@RequiredArgsConstructor
public class DomaineController {

    private final DomaineService domaineService;

    @GetMapping
    public ResponseEntity<List<DomaineDto>> getAllDomaines() {
        return ResponseEntity.ok(domaineService.getAll());
    }

    @PostMapping
    public ResponseEntity<DomaineDto> createDomaine(
             @RequestBody DomaineDto dto) {
        return new ResponseEntity<>(domaineService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DomaineDto> updateDomaine(
            @PathVariable Long id,
            @RequestBody DomaineDto dto) {
        return ResponseEntity.ok(domaineService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDomaine(@PathVariable Long id) {
        domaineService.delete(id);
        return ResponseEntity.noContent().build();
    }
}