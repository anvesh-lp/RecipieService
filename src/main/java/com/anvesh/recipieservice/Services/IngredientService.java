package com.anvesh.recipieservice.Services;

import com.anvesh.recipieservice.dto.IngredientDTO;
import com.anvesh.recipieservice.models.Ingredient;

import java.util.List;

public interface IngredientService {
    public List<Ingredient> findAll();

    public List<Ingredient> findByName(String name);

    public Ingredient save(Ingredient ingredient);

    public Ingredient findById(Long id);

    public Ingredient save(IngredientDTO ingredientDTO);

}
