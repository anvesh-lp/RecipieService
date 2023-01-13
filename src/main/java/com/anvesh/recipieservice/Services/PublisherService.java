package com.anvesh.recipieservice.Services;

import com.anvesh.recipieservice.dto.IngredientDTO;
import com.anvesh.recipieservice.dto.PublisherDTO;
import com.anvesh.recipieservice.models.Ingredient;
import com.anvesh.recipieservice.models.Publisher;

import java.util.List;

public interface PublisherService {
    public Publisher save(Publisher publisher);

    public Publisher save(PublisherDTO publisherDTO);

    public List<Publisher> findAll();

    Publisher findById(Long id);

    Ingredient save(IngredientDTO ingredientDTO);
}
