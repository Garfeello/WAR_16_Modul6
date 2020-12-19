package pl.coderslab.Spring01hibernate.controllerForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Spring01hibernate.dao.AuthorDao;
import pl.coderslab.Spring01hibernate.model.Author;

import java.util.List;

@Controller
@RequestMapping("/authorForm")
public class AuthorFormController {

    private final AuthorDao authorDao;

    public AuthorFormController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @ModelAttribute("allAuthors")
    public List<Author> allAuthors() {
        return authorDao.findAll();
    }

    @GetMapping("/")
    public String showAuthorList(Model model) {
        model.addAttribute("allAuthors", authorDao.findAll());
        return "author/all";
    }

    @GetMapping("/add")
    public String initAddAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "author/addAndEdit";
    }

    @PostMapping("/add")
    public String persistAuthor(@ModelAttribute Author author) {
        authorDao.persist(author);
        return "redirect:";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam int toEditId, Model model) {
        model.addAttribute("author", authorDao.findById(toEditId));
        return "author/addAndEdit";
    }

    @PostMapping("/edit")
    public String editAuthor(@ModelAttribute Author author) {
        authorDao.merge(author);
        return "redirect:";
    }

    @GetMapping("/remove")
    public String prepareRemove(@RequestParam int toRemoveId, Model model) {
        model.addAttribute("author", authorDao.findById(toRemoveId));
        return "author/remove";
    }

    @PostMapping("/remove")
    public String remove(@ModelAttribute Author author, @RequestParam String confirmed) {
        if("yes".equals(confirmed)) {
            authorDao.removeById(author.getId());
        }
        return "redirect:";
    }

}
