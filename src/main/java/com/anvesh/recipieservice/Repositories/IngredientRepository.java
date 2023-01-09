package com.anvesh.recipieservice.Repositories;

import com.anvesh.recipieservice.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<List<Ingredient>> findAllByName(String name);
}
