package com.anvesh.recipieservice.Services;

import com.anvesh.recipieservice.Exceptions.ResourceNotFoundException;
import com.anvesh.recipieservice.Repositories.PublisherRepository;
import com.anvesh.recipieservice.dto.IngredientDTO;
import com.anvesh.recipieservice.dto.PublisherDTO;
import com.anvesh.recipieservice.models.Ingredient;
import com.anvesh.recipieservice.models.Publisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PublisherServiceImp implements PublisherService {

    private final PublisherRepository publisherRepo;

    public PublisherServiceImp(PublisherRepository publisherRepo) {
        this.publisherRepo = publisherRepo;
    }


    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    @Override
    @Transactional
    public Publisher save(PublisherDTO publisherDTO) {
        return publisherRepo.save(new Publisher(publisherDTO.getName()));
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepo.findAll();
    }

    @Override
    public Publisher findById(Long id) {
        return publisherRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("cant find resource in publisher"));
    }

    @Override
    public Ingredient save(IngredientDTO ingredientDTO) {
        return null;
    }
}
