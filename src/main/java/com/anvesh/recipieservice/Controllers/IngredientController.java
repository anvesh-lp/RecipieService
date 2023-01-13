package com.anvesh.recipieservice.Controllers;

import com.anvesh.recipieservice.Services.IngredientService;
import com.anvesh.recipieservice.dto.IngredientDTO;
import com.anvesh.recipieservice.models.Ingredient;
import com.anvesh.recipieservice.respone.ResponseIngredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IngredientController {

    private final IngredientService ingredientRepository;

    Logger logger = LoggerFactory.getLogger(IngredientController.class);


    public IngredientController(IngredientService ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/ingredients")
    public List<ResponseIngredient> getAllIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        return ingredients.stream().map(ingredient -> {
                    ResponseIngredient responseIngredient = new ResponseIngredient();
                    responseIngredient.setName(ingredient.getName());
                    return responseIngredient;
                }
        ).collect(Collectors.toList());
    }

    @GetMapping("/ingredient/{id}")
    public ResponseEntity<IngredientDTO> getIngredientById(@PathVariable Long id) {
        logger.info("Ingredient controller getIngredients called");
        Ingredient ingredient = ingredientRepository.findById(id);
        return new ResponseEntity<>(new IngredientDTO(ingredient.getName(), ingredient.getQuantity()),
                HttpStatus.OK);
    }

    @PostMapping("/ingredient")
    public ResponseEntity<IngredientDTO> getIngredientById(@RequestBody IngredientDTO ingredientDTO) {
        Ingredient ingredient = ingredientRepository.save(ingredientDTO);
        logger.info("Ingredient Created " + ingredient.getId());
        return new ResponseEntity<>(new IngredientDTO(ingredient.getName(), ingredient.getQuantity()),
                HttpStatus.CREATED);
    }

}
