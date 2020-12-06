package pl.coderslab.Spring01hibernate.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Spring01hibernate.model.Book;
import pl.coderslab.Spring01hibernate.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public Publisher merge(Publisher publisher) {
        return entityManager.merge(publisher);
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void removeById(long id) {
        Publisher publisher = findById(id);
        publisher = entityManager.contains(publisher) ? publisher : merge(publisher);
        entityManager.remove(publisher);
    }

    public List<Publisher> findAll() {
        Query query = entityManager.createQuery("SELECT p from Publisher p");
        return query.getResultList();
    }

}
