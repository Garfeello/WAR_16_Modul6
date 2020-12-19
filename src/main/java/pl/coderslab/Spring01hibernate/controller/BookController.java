package pl.coderslab.Spring01hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01hibernate.dao.AuthorDao;
import pl.coderslab.Spring01hibernate.dao.BookDao;
import pl.coderslab.Spring01hibernate.dao.PublisherDao;
import pl.coderslab.Spring01hibernate.model.Author;
import pl.coderslab.Spring01hibernate.model.Book;
import pl.coderslab.Spring01hibernate.model.Publisher;
import pl.coderslab.Spring01hibernate.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookRepository bookRepository;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/repositoryTitle")
    @ResponseBody
    public String repositoryTestTitle() {
        bookRepository.findByTitle("sadasdsa")
                .map(Book::getId)
                .ifPresent(System.out::println);
        return "Wyswielone informacje na konsoli";
    }

    @GetMapping("/respositoryCat")
    @ResponseBody
    public String repositoryCatIdTest() {
        bookRepository.findAllByCategory_Id(2L)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
        return "Wyswietlone info na konsoli";
    }

    @GetMapping("/persist")
    @ResponseBody
    public String persist() {
        Book book = new Book();
        book.setTitle("Czerwony kapturek");
        book.setRating(4);
        book.setDescription("Opis o ksiazke czerwony kapturek");

        Publisher publisher = new Publisher();
        publisher.setName("Wydawnictwo PWN");
        publisherDao.persist(publisher);
        book.setPublisher(publisher);

        Author firstAuthor = authorDao.findById(1L);
        Author secondAuthor = authorDao.findById(2L);
        book.getAuthorList().add(firstAuthor);
        book.getAuthorList().add(secondAuthor);

        bookDao.persist(book);
        return "Zapisano książkę i nadano jej id: " + book.getId();
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public String findById(@PathVariable("id") long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @GetMapping("/merge/{id}")
    @ResponseBody
    public String merge(@PathVariable("id") long id) {
        Book book = bookDao.findById(id);
        book.setTitle("Zaktualizowany tytual");
        bookDao.merge(book);
        return "Zaktualizowano ksiazke o id " + id;
    }

    @GetMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") long id) {
        bookDao.removeById(id);
        return "Usunieto ksiazke";
    }

    @GetMapping("/findAll")
    @ResponseBody
    public String findAll() {
        List<Book> allBooks = bookDao.findAll();
        return allBooks.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("<br />"));
    }

    @GetMapping("/rating/{rating}")
    @ResponseBody
    public String getRatingList(@PathVariable("rating") int rating) {
        List<Book> booksByRating = bookDao.getRatingList(rating);
        return booksByRating.stream()
                .map(Book::titleWithRating)
                .collect(Collectors.joining("<br />"));
    }

    @GetMapping("/publisher")
    @ResponseBody
    public String findWithPublisher() {
        List<Book> booksWithPublisher = bookDao.findAllWithPublisher();
        return booksWithPublisher.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("<br />"));
    }

    @GetMapping("/byAuthor/{authorId}")
    @ResponseBody
    public String byAuthor(@PathVariable("authorId") int authorId) {
        Author author = authorDao.findById(authorId);
        List<Book> booksByAuthor = bookDao.findAllByAuthor(author);
        return booksByAuthor.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("<br />"));
    }



}
