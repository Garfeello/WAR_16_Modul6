package pl.coderslab.Spring01hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Spring01hibernate.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
