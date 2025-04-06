package com.example.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.model.Domaine;

public interface DomaineRepository extends JpaRepository<Domaine, Long> {
}
