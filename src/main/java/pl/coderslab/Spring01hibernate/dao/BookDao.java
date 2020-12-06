package pl.coderslab.Spring01hibernate.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Spring01hibernate.model.Author;
import pl.coderslab.Spring01hibernate.model.Book;
import pl.coderslab.Spring01hibernate.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Book book) {
        entityManager.persist(book);
    }

    public Book merge(Book book) {
        return entityManager.merge(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void removeById(long id) {
        Book book = findById(id);
        book = entityManager.contains(book) ? book : merge(book);
        entityManager.remove(book);
    }

    public List<Book> findAll() {
        Query query = entityManager.createQuery("SELECT b from Book b");
        return query.getResultList();
    }

    public List<Book> getRatingList(int rating) {
        Query query = entityManager.createQuery("SELECT b from Book b where b.rating = :givenRating");
        query.setParameter("givenRating", rating);
        return query.getResultList();
    }

    public List<Book> findAllWithPublisher() {
        Query query = entityManager.createQuery("SELECT b from Book b where b.publisher is not null");
        return query.getResultList();
    }

    public List<Book> findAllByPublisher(Publisher publisher) {
        Query query = entityManager.createQuery("SELECT b FROM Book b where b.publisher = :publisher");
        query.setParameter("publisher", publisher);
        return query.getResultList();
    }

    public List<Book> findAllByAuthor(Author author) {
        Query query = entityManager.createQuery("SELECT b from Book b inner join b.authorList a where a.id = :authorId");
        query.setParameter("authorId", author.getId());
        return query.getResultList();
    }

}
