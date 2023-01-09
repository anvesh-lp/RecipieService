package com.anvesh.recipieservice.Controllers;

import com.anvesh.recipieservice.Services.IngredientService;
import com.anvesh.recipieservice.models.Ingredient;
import com.anvesh.recipieservice.respone.ResponseIngredient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IngredientController {

    private final IngredientService ingredientRepository;

    public IngredientController(IngredientService ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/ingredients")
    public List<ResponseIngredient> getAllIngredients(){
        List<Ingredient> ingredients =  ingredientRepository.findAll();
       return  ingredients.stream().map(ingredient -> {
           ResponseIngredient responseIngredient = new ResponseIngredient();
           responseIngredient.setName(ingredient.getName());
           return responseIngredient;
                }
        ).collect(Collectors.toList());
    }



}
