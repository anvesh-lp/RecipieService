package com.anvesh.recipieservice.Services;

import com.anvesh.recipieservice.Repositories.RecipeRepository;
import com.anvesh.recipieservice.models.Recipie;
import org.springframework.stereotype.Component;

@Component
public class RecipeServiceImp implements RecipeService {
    private final RecipeRepository recipeRepo;

    public RecipeServiceImp(RecipeRepository recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @Override
    public Recipie save(Recipie recipie) {
        return recipeRepo.save(recipie);
    }
}
