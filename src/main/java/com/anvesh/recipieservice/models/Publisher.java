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
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(targetEntity = Recipie.class)
    @Column(name = "recipie_id")
    private Set<Recipie> recipieId = new HashSet<>();

    public Publisher(String name) {
        this.name = name;
    }

    public void add(Recipie recipie) {
        this.recipieId.add(recipie);
        recipie.setPublisher_id(this);
    }

}
