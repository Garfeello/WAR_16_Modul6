package pl.coderslab.Spring01hibernate.controllerForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Spring01hibernate.dao.PublisherDao;
import pl.coderslab.Spring01hibernate.model.Publisher;
import pl.coderslab.Spring01hibernate.service.PublisherSearchService;

import javax.validation.Valid;

@Controller
@RequestMapping("/publisherForm")
public class PublisherFormController {

    private final PublisherDao publisherDao;
    private final PublisherSearchService publisherSearchService;

    public PublisherFormController(PublisherDao publisherDao, PublisherSearchService publisherSearchService) {
        this.publisherDao = publisherDao;
        this.publisherSearchService = publisherSearchService;

    }

    @GetMapping("/")
    public String showPublisherList(Model model,
                                    @RequestParam(required = false) String searchMode,
                                    @RequestParam(required = false) String query) {
        model.addAttribute("allPublishers", publisherSearchService.executeQuery(searchMode, query));
        return "publisher/all";
    }

    @GetMapping("/add")
    public String initAddPublisher(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/addAndEdit";
    }

    @PostMapping("/add")
    public String persistPublisher(@ModelAttribute @Valid Publisher publisher, BindingResult result) {
        if(result.hasErrors()) {
            return "publisher/addAndEdit";
        }
        publisherDao.persist(publisher);
        return "redirect:";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam int toEditId, Model model) {
        model.addAttribute("publisher", publisherDao.findById(toEditId));
        return "publisher/addAndEdit";
    }

    @PostMapping("/edit")
    public String editPublisher(@ModelAttribute @Valid Publisher publisher, BindingResult result) {
        if(result.hasErrors()) {
            return "publisher/addAndEdit";
        }
        publisherDao.merge(publisher);
        return "redirect:";
    }

    @GetMapping("/remove")
    public String prepareRemove(@RequestParam int toRemoveId, Model model) {
        model.addAttribute("publisher", publisherDao.findById(toRemoveId));
        return "publisher/remove";
    }

    @PostMapping("/remove")
    public String remove(@ModelAttribute Publisher publisher, @RequestParam String confirmed) {
        if("yes".equals(confirmed)) {
            publisherDao.removeById(publisher.getId());
        }
        return "redirect:";
    }

}
