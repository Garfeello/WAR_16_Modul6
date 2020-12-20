package pl.coderslab.Spring01hibernate.service.search;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import pl.coderslab.Spring01hibernate.model.Book;
import pl.coderslab.Spring01hibernate.repository.BookRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class BookSearchService {

    private final BookRepository bookRepository;

    public BookSearchService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> executeQuery(Map<String, String> allParams) {
        String searchMode = allParams.getOrDefault("searchMode", StringUtils.EMPTY);
        String query = allParams.get("query");

        switch (searchMode) {
            case "title":
                if(StringUtils.isEmpty(query)) {
                    return bookRepository.findAll();
                }
                return bookRepository.findByTitleIgnoringCaseContaining(query);
            case "description":
                if(StringUtils.isEmpty(query)) {
                    return bookRepository.findAll();
                }
                return bookRepository.findAllByDescriptionIgnoringCaseContaining(query);
            case "author":
                String authorId = allParams.get("searchAuthor");
                return bookRepository.findByAuthorList_Id(Long.parseLong(authorId));
            default:
                return bookRepository.findAll();
        }
    }

}
