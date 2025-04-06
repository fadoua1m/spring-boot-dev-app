package com.example.dev.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contribution {
    @Id @GeneratedValue
    private Long id;

    private String type; 
    private String lieu;

    @ManyToOne
    private User user;

    @ManyToOne
    private Article article;
}

