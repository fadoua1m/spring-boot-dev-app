package com.example.dev.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article {
    @Id @GeneratedValue
    private Long id;

    private String doi;
    private String titre;
    private String motsCles;

    @OneToMany(mappedBy = "article")
    private List<Contribution> contributions;

    @ManyToOne
    private Domaine domaine;
}

