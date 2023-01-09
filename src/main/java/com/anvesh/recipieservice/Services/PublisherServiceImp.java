package com.anvesh.recipieservice.Services;

import com.anvesh.recipieservice.Repositories.PublisherRepository;
import com.anvesh.recipieservice.models.Publisher;
import org.springframework.stereotype.Component;

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
}
