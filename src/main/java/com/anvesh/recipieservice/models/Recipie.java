package com.anvesh.recipieservice.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Recipie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    //    @Column(name = "publisher", nullable = false)
    @OneToOne(targetEntity = Publisher.class)
    private Publisher publisher_id;
    @ManyToMany()
    @JoinTable(
            name = "ingredient_recipie",
            joinColumns = @JoinColumn(name = "Ingredients_id"),
            inverseJoinColumns = @JoinColumn(name = "recipies")
    )
    private Set<Ingredient> ingredients;

    public Recipie(String name) {
        this.name = name;
    }
}
