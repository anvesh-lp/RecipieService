package com.anvesh.recipieservice.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;
    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    private Set<Recipie> recipies = new HashSet<>();

    public Ingredient(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

}
