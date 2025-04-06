package com.example.dev.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDto{
    private Long id;
    private String fullName;
    private String email;
    private LocalDate dateEmbauche;
    private String etablissementOrigine;
    private String dernierDiplome;
    private String grade;
    private String role;
    
}
