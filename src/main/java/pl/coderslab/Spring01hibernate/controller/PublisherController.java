package pl.coderslab.Spring01hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01hibernate.dao.PublisherDao;
import pl.coderslab.Spring01hibernate.model.Publisher;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/persist")
    @ResponseBody
    public String persist() {
        Publisher publisher = new Publisher();
        publisher.setName("Nowa ERA");

        publisherDao.persist(publisher);
        return "Zapisano wydawce i nadano mu id: " + publisher.getId();
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public String findById(@PathVariable("id") long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @GetMapping("/merge/{id}")
    @ResponseBody
    public String merge(@PathVariable("id") long id) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName("Stara ERA");
        publisherDao.merge(publisher);
        return "Zaktualizowano wydawce o id " + id;
    }

    @GetMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") long id) {
        publisherDao.removeById(id);
        return "Usunieto wydawce";
    }

}
