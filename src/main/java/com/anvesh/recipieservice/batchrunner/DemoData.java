package com.anvesh.recipieservice.batchrunner;

import com.anvesh.recipieservice.Repositories.PublisherRepository;
import com.anvesh.recipieservice.Services.IngredientService;
import com.anvesh.recipieservice.models.Publisher;
import com.anvesh.recipieservice.models.Recipie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoData implements CommandLineRunner {

    private final IngredientService ingredientRepo;
    private final PublisherRepository publisherRepository;

    public DemoData(IngredientService ingredientRepo,
                    PublisherRepository publisherRepository) {
        this.ingredientRepo = ingredientRepo;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        saveIngredients();
    }

    private void saveIngredients() {

    }

    private void saveData() {
        Publisher p1 = new Publisher("Anvesh");
        Publisher p2 = new Publisher("Vamshi");
        Publisher p3 = new Publisher("ganesh");

        Recipie r1 = new Recipie("Biryani");
        Recipie r2 = new Recipie("chicken biryani");
        Recipie r3 = new Recipie("paneer masala");

        r1.setPublisher_id(p1);
        r2.setPublisher_id(p2);
        r3.setPublisher_id(p3);

        p1.getRecipieId().add(r1);
        p2.getRecipieId().add(r2);
        p3.getRecipieId().add(r3);




    }

}
