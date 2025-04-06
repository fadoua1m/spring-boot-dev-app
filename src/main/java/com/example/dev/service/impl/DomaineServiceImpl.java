package com.example.dev.service.impl;

import com.example.dev.dto.*;
import com.example.dev.model.*;
import com.example.dev.repository.*;
import com.example.dev.service.DomaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomaineServiceImpl implements DomaineService {

    @Autowired
    private DomaineRepository domaineRepository;

    @Override
    public DomaineDto create(DomaineDto dto) {
        Domaine domaine = new Domaine();
        domaine.setNomDomaine(dto.getNomDomaine());
        
        Domaine savedDomaine = domaineRepository.save(domaine);
        return mapToDto(savedDomaine);
    }

    @Override
    public List<DomaineDto> getAll() {
        return domaineRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DomaineDto update(Long id, DomaineDto dto) {
        Domaine domaine = domaineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Domaine not found"));
        
        domaine.setNomDomaine(dto.getNomDomaine());
        Domaine updatedDomaine = domaineRepository.save(domaine);
        return mapToDto(updatedDomaine);
    }

    @Override
    public void delete(Long id) {
        domaineRepository.deleteById(id);
    }

    private DomaineDto mapToDto(Domaine domaine) {
        DomaineDto dto = new DomaineDto();
        dto.setId(domaine.getId());
        dto.setNomDomaine(domaine.getNomDomaine());
        return dto;
    }
}