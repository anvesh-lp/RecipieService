package com.anvesh.recipieservice.Services;

import com.anvesh.recipieservice.Exceptions.ResourceNotFoundException;
import com.anvesh.recipieservice.Repositories.IngredientRepository;
import com.anvesh.recipieservice.dto.IngredientDTO;
import com.anvesh.recipieservice.models.Ingredient;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Ingredient findById(Long id) {
        Optional<Ingredient> ingredientOptional = ingredientRepo.findById(id);
        return ingredientOptional.orElseThrow(() -> new ResourceNotFoundException("Cant find id " + id));
    }

    @Override
    @Transactional
    public Ingredient save(IngredientDTO ingredientDTO) {
        Ingredient savedIngredient = ingredientRepo.save(new Ingredient(ingredientDTO.getName(), ingredientDTO.getQuantity()));
        return savedIngredient;
    }

}
