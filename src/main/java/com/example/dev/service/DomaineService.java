package com.example.dev.service;

import com.example.dev.dto.*;

import java.util.List;

public interface DomaineService {
    DomaineDto create(DomaineDto dto);
    List<DomaineDto> getAll();
    DomaineDto update(Long id, DomaineDto dto);
    void delete(Long id);
}
