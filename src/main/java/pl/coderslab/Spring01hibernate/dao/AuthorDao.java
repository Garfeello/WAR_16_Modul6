package pl.coderslab.Spring01hibernate.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Spring01hibernate.model.Author;
import pl.coderslab.Spring01hibernate.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Author author) {
        entityManager.persist(author);
    }

    public Author merge(Author author) {
        return entityManager.merge(author);
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void removeById(long id) {
        Author author = findById(id);
        author = entityManager.contains(author) ? author : merge(author);
        entityManager.remove(author);
    }

    public List<Author> findAll() {
        Query query = entityManager.createQuery("SELECT a from Author a");
        return query.getResultList();
    }
    
}
