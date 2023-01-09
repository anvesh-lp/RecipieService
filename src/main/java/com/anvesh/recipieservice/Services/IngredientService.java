package com.anvesh.recipieservice.Services;

import com.anvesh.recipieservice.models.Ingredient;

import java.util.List;

public interface IngredientService {
    public List<Ingredient> findAll();

    public List<Ingredient> findByName(String name);

}
