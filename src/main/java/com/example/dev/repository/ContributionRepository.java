package com.example.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.model.Contribution;

public interface ContributionRepository extends JpaRepository<Contribution, Long> {
}
