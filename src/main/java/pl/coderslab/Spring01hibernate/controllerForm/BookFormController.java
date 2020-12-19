package pl.coderslab.Spring01hibernate.controllerForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Spring01hibernate.dao.AuthorDao;
import pl.coderslab.Spring01hibernate.dao.BookDao;
import pl.coderslab.Spring01hibernate.dao.PublisherDao;
import pl.coderslab.Spring01hibernate.model.Author;
import pl.coderslab.Spring01hibernate.model.Book;
import pl.coderslab.Spring01hibernate.model.Publisher;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/bookForm")
public class BookFormController {

    private final PublisherDao publisherDao;
    private final BookDao bookDao;
    private final AuthorDao authorDao;

    public BookFormController(PublisherDao publisherDao, BookDao bookDao, AuthorDao authorDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @ModelAttribute("allPublishers")
    public List<Publisher> allPublishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("allAuthors")
    public List<Author> allAuthors() {
        return authorDao.findAll();
    }

    @GetMapping("/")
    public String showBookList(Model model) {
        model.addAttribute("allBooks", bookDao.findAll());
        return "book/all";
    }

    @GetMapping("/add")
    public String initAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/addAndEdit";
    }

    @PostMapping("/add")
    public String persistBook(@ModelAttribute @Valid Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "book/addAndEdit";
        }
        bookDao.persist(book);
        return "redirect:";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam int toEditId, Model model) {
        model.addAttribute("book", bookDao.findById(toEditId));
        return "book/addAndEdit";
    }

    @PostMapping("/edit")
    public  String editBook(@ModelAttribute @Valid Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "book/addAndEdit";
        }
        bookDao.merge(book);
        return "redirect:";
    }

    @GetMapping("/remove")
    public String prepareRemove(@RequestParam int toRemoveId, Model model) {
        model.addAttribute("book", bookDao.findById(toRemoveId));
        return "book/remove";
    }

    @PostMapping("/remove")
    public String remove(@ModelAttribute Book book, @RequestParam String confirmed) {
        if ("yes".equals(confirmed)) {
            bookDao.removeById(book.getId());
        }
        return "redirect:";
    }

}
