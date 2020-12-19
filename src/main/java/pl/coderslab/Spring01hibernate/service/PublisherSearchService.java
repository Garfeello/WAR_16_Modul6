package pl.coderslab.Spring01hibernate.service;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.coderslab.Spring01hibernate.model.Publisher;
import pl.coderslab.Spring01hibernate.repository.PublisherRepository;

import java.util.Collections;
import java.util.List;

@Component
public class PublisherSearchService {

    private final PublisherRepository publisherRepository;

    public PublisherSearchService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> executeQuery(String searchMode, String query) {
        if (StringUtils.isEmpty(searchMode)) {
            return publisherRepository.findAll();
        }

        if(StringUtils.isEmpty(query)) {
            return publisherRepository.findAll();
        }

        switch (searchMode) {
            case "name":
                return publisherRepository.findByNameIgnoreCaseContaining(query);
            case "nip":
                return publisherRepository.findByNipContaining(query);
            case "regon":
                return publisherRepository.findByRegonContaining(query);
        }

        return Collections.emptyList();
    }

}
