package pl.coderslab.Spring01hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Spring01hibernate.dao.PersonDao;
import pl.coderslab.Spring01hibernate.model.Person;
import pl.coderslab.Spring01hibernate.model.PersonDetails;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/form")
    public String initForm(Model model) {
        model.addAttribute("person", new Person());
        return "person/person";
    }

    @PostMapping("/form")
    @ResponseBody
    public String processPersist(@ModelAttribute Person person) {
        personDao.persist(person);
        return "Zapisano pomyslnie";
    }

  /*
    @GetMapping("/form")
    public String initForm() {
        return "person/person";
    }

    @PostMapping("/form")
    @ResponseBody
    public String processPersist(@RequestParam String login,
                                 @RequestParam String password,
                                 @RequestParam String email) {
        Person person = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);

        personDao.persist(person);

        return "Zapisano pomyślnie";
    }*/

    @GetMapping("/persist")
    @ResponseBody
    public String persist() {
        Person person = new Person();
        person.setLogin("test");
        person.setPassword("test123");
        person.setEmail("test@o2.pl");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Maciej");
        personDetails.setLastName("Kowalski");
        personDetails.setCity("Warszawa");
        personDetails.setStreet("Prosta");
        personDetails.setStreetNumber("33");

        person.setPersonDetails(personDetails);

        personDao.persist(person);
        return "Zapisano osobe i nadano jej id: " + person.getId();
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public String findById(@PathVariable("id") long id) {
        Person person = personDao.findById(id);
        return person.toString();
    }

    @GetMapping("/merge/{id}")
    @ResponseBody
    public String merge(@PathVariable("id") long id) {
        Person person = personDao.findById(id);
        person.setPassword("Super ekstra tajne nowe haslo");
        person.getPersonDetails().setFirstName("Staszek");
        personDao.merge(person);
        return "Zaktualizowano osobe o id " + id;
    }

    @GetMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable("id") long id) {
        personDao.removeById(id);
        return "Usunieto osobe";
    }
}
