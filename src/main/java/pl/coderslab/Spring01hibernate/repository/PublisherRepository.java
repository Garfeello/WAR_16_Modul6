package pl.coderslab.Spring01hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.Spring01hibernate.model.Publisher;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    List<Publisher> findByNameIgnoreCaseContaining(String name);

    List<Publisher> findByNipContaining(String nip);

    List<Publisher> findByRegonContaining(String regon);

}
