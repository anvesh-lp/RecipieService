package com.anvesh.recipieservice.batchrunner;

import com.anvesh.recipieservice.Services.IngredientService;
import com.anvesh.recipieservice.Services.PublisherService;
import com.anvesh.recipieservice.Services.RecipeService;
import com.anvesh.recipieservice.models.Ingredient;
import com.anvesh.recipieservice.models.Publisher;
import com.anvesh.recipieservice.models.Recipie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

        if (ingredientRepo.findAll().size() == 0)
            saveData();
    }


    @Transactional
    protected void saveData() {
        Publisher p1 = new Publisher("Anvesh");
        Publisher p2 = new Publisher("Vamshi");
        Publisher p3 = new Publisher("ganesh");

        Recipie r1 = new Recipie("Biryani");
        Recipie r2 = new Recipie("chicken biryani");
        Recipie r3 = new Recipie("paneer masala");

        Ingredient rice = new Ingredient("Rice", 100);
        Ingredient water = new Ingredient("water", 20);
        Ingredient paneers = new Ingredient("Paneer", 100);
        Ingredient tomatoes = new Ingredient("tomato", 10);
        Ingredient chicken = new Ingredient("Chicken", 300);

//        r1.setPublisher_id(p1);
//        r2.setPublisher_id(p2);
//        r3.setPublisher_id(p3);

        rice = ingredientRepo.save(rice);
        water = ingredientRepo.save(water);
        paneers = ingredientRepo.save(paneers);
        tomatoes = ingredientRepo.save(tomatoes);
        chicken = ingredientRepo.save(chicken);

        r1.getIngredients().add(rice);
        r1.getIngredients().add(water);
        r1.getIngredients().add(tomatoes);

        r2.getIngredients().add(rice);
        r2.getIngredients().add(water);
        r2.getIngredients().add(tomatoes);
        r2.getIngredients().add(chicken);

        r3.getIngredients().add(paneers);
        r3.getIngredients().add(water);

        water.getRecipies().add(r1);
        water.getRecipies().add(r2);
        water.getRecipies().add(r3);

        rice.getRecipies().add(r1);
        rice.getRecipies().add(r2);

        paneers.getRecipies().add(r3);
        tomatoes.getRecipies().add(r3);
        tomatoes.getRecipies().add(r2);

        chicken.getRecipies().add(r1);
        chicken.getRecipies().add(r2);


        r1.addPublisher(p1);
        r2.addPublisher(p1);
        r3.addPublisher(p2);

        p1.add(r1);
        p1.add(r2);
        p2.add(r3);

//        p1.getRecipieId().add(r1);
//        p2.getRecipieId().add(r2);
//        p3.getRecipieId().add(r3);
//        p1.getRecipieId().add(r1);
//        p1.getRecipieId().add(r2);
//        p2.getRecipieId().add(r3);


//        r1.setPublisher_id(p1);
//        r2.setPublisher_id(p2);
//        r3.setPublisher_id(p2);

        publisherRepository.save(p1);
        publisherRepository.save(p2);
        publisherRepository.save(p3);

        recipeRepository.save(r1);
        recipeRepository.save(r2);
        recipeRepository.save(r3);

//        p1.add(r1);

    }

}
