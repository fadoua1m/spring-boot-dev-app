package com.example.dev.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CreateUserDto {
    private String fullName;
    private String pwd;
    private String email;
    private LocalDate dateEmbauche;
    private String etablissementOrigine;
    private String dernierDiplome;
    private String grade;
    private String role; 
}
