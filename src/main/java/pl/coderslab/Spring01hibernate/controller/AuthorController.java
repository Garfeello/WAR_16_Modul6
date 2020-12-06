package pl.coderslab.Spring01hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01hibernate.dao.AuthorDao;
import pl.coderslab.Spring01hibernate.model.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/persist")
    @ResponseBody
    public String persist() {
        Author author = new Author();
        author.setFirstName("Piotr");
        author.setLastName("Nowak");

        authorDao.persist(author);
        return "Zapisano autora i nadano mu id: " + author.getId();
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public String findById(@PathVariable("id") long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @GetMapping("/merge/{id}")
    @ResponseBody
    public String merge(@PathVariable("id") long id) {
        Author author = authorDao.findById(id);
        author.setFirstName("Stanislaw");
        authorDao.merge(author);
        return "Zaktualizowano autora o id " + id;
    }

    @GetMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") long id) {
        authorDao.removeById(id);
        return "Usunieto autora";
    }
}
