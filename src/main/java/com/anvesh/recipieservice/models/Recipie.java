package com.anvesh.recipieservice.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "recipie")
public class Recipie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    //    @Column(name = "publisher", nullable = false)
    @ManyToOne
    @JoinColumn(name = "publisher", insertable = false)
    private Publisher publisher_id;


    @ManyToMany()
    @JoinTable(
            name = "ingredient_recipie",
            joinColumns = @JoinColumn(name = "recipie"),
            inverseJoinColumns = @JoinColumn(name = "Ingredient_id")
    )
    @Column(nullable = false)
    private Set<Ingredient> ingredients = new HashSet<>();

    public Recipie(String name) {
        this.name = name;
    }

//    public void add(Ingredient ingredient) {
//        this.ingredients.add(ingredient);
//        ingredient.getRecipies().add(this);
//    }

    public void addPublisher(Publisher publisher) {
        this.publisher_id = publisher;
    }


}
