package com.anvesh.recipieservice.batchrunner;

import com.anvesh.recipieservice.Services.IngredientService;
import com.anvesh.recipieservice.Services.PublisherService;
import com.anvesh.recipieservice.Services.RecipeService;
import com.anvesh.recipieservice.models.Ingredient;
import com.anvesh.recipieservice.models.Publisher;
import com.anvesh.recipieservice.models.Recipie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoData implements CommandLineRunner {


    private final IngredientService ingredientRepo;
    private final RecipeService recipeRepository;

    private final PublisherService publisherRepository;

    public DemoData(IngredientService ingredientRepo, RecipeService recipeRepository, PublisherService publisherRepository) {
        this.ingredientRepo = ingredientRepo;
        this.recipeRepository = recipeRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        saveData();
    }


    private void saveData() {
        Publisher p1 = new Publisher("Anvesh");
        Publisher p2 = new Publisher("Vamshi");
        Publisher p3 = new Publisher("ganesh");

        Recipie r1 = new Recipie("Biryani");
        Recipie r2 = new Recipie("chicken biryani");
        Recipie r3 = new Recipie("paneer masala");

//        r1.setPublisher_id(p1);
//        r2.setPublisher_id(p2);
//        r3.setPublisher_id(p3);

        p1.add(r1);
        p2.add(r2);
        p3.add(r3);


        Ingredient rice = new Ingredient("Rice", 100);
        Ingredient water = new Ingredient("water", 20);
        Ingredient paneers = new Ingredient("Paneer", 100);
        Ingredient tomatoes = new Ingredient("tomato", 10);
        Ingredient chicken = new Ingredient("Chicken", 300);

        r1.add(rice);
        r1.add(water);
        r1.add(tomatoes);

        r2.add(rice);
        r2.add(water);
        r2.add(tomatoes);
        r2.add(chicken);

        r3.add(paneers);
        r3.add(water);


//        p1.add(r1);

        publisherRepository.save(p1);
        publisherRepository.save(p2);
        publisherRepository.save(p3);

        recipeRepository.save(r1);
        recipeRepository.save(r2);
        recipeRepository.save(r3);


    }

}
