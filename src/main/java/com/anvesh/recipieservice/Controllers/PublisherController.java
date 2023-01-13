package com.anvesh.recipieservice.Controllers;

import com.anvesh.recipieservice.Services.PublisherService;
import com.anvesh.recipieservice.dto.PublisherDTO;
import com.anvesh.recipieservice.models.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PublisherController {

    private final PublisherService publisherRepository;

    Logger logger = LoggerFactory.getLogger(PublisherController.class);

    public PublisherController(PublisherService publisherRepository) {
        this.publisherRepository = publisherRepository;
    }


    @GetMapping("/publisher")
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> ingredients = publisherRepository.findAll();
        return ingredients.stream().map(publisher -> {
                    PublisherDTO dto = new PublisherDTO();
                    publisher.setName(publisher.getName());
                    return dto;
                }
        ).collect(Collectors.toList());
    }

    @GetMapping("/publisher/{id}")
    public ResponseEntity<PublisherDTO> getPublisherById(@PathVariable Long id) {
        logger.info("Ingredient controller getIngredients called");
        Publisher publisher = publisherRepository.findById(id);
        return new ResponseEntity<>(new PublisherDTO(publisher.getName()),
                HttpStatus.OK);
    }

    @PostMapping("/publisher")
    public ResponseEntity<PublisherDTO> getPublisherById(@RequestBody PublisherDTO publisherDTO) {
        Publisher publisher = publisherRepository.save(publisherDTO);
        logger.info("Ingredient Created " + publisher.getId());
        return new ResponseEntity<>(new PublisherDTO(publisher.getName()),
                HttpStatus.CREATED);
    }

}
