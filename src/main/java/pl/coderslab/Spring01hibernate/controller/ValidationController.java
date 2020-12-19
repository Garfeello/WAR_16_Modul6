package pl.coderslab.Spring01hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Spring01hibernate.model.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validation")
public class ValidationController {

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    @ResponseBody
    public String validate() {
        Book book = new Book();
        book.setTitle("asdsadd");
        book.setRating(8);
        book.setDescription("asdafasfasfdasd");
        book.setPages(7);
        Set<ConstraintViolation<Book>> validationResult = validator.validate(book);
        if (!validationResult.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : validationResult) {
                System.out.println("Błąd!!!!!!!! " + constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
            }
            return "Encja niepoprawna";
        } else {
            return "Encja poprawna";
        }
    }

    @GetMapping("/validateView")
    public String validateView(Model model) {
        Book book = new Book();
        book.setTitle("asdsadd");
        book.setRating(11);
        book.setDescription("asdafasfasfdasd");
        book.setPages(7);
        Set<ConstraintViolation<Book>> validationResult = validator.validate(book);
        model.addAttribute("validationResult", validationResult);
        return "validation/result";
    }

}
