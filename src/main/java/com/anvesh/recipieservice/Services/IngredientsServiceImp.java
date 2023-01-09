package com.anvesh.recipieservice.Services;

import com.anvesh.recipieservice.Exceptions.ResourceNotFoundException;
import com.anvesh.recipieservice.Repositories.IngredientRepository;
import com.anvesh.recipieservice.models.Ingredient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class IngredientsServiceImp implements IngredientService {

    private final IngredientRepository ingredientRepo;

    public IngredientsServiceImp(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    public List<Ingredient> findAll() {
        return ingredientRepo.findAll();
    }

    public List<Ingredient> findByName(String name) {
        Optional<List<Ingredient>> ingredients = ingredientRepo.findAllByName(name);
        return ingredients.orElseThrow(() -> new ResourceNotFoundException("Cant find resource with name " + name));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepo.save(ingredient);
    }


}
