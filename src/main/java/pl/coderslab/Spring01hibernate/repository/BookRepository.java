package pl.coderslab.Spring01hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.Spring01hibernate.model.Author;
import pl.coderslab.Spring01hibernate.model.Book;
import pl.coderslab.Spring01hibernate.model.Category;
import pl.coderslab.Spring01hibernate.model.Publisher;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleIgnoringCaseContaining(String title);

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByCategory_Id(long id);

    @Query("SELECT b FROM Book b WHERE b.title = :title")
    Optional<Book> findMyBooksByTitle(@Param("title") String title);

    @Query("SELECT b FROM Book b WHERE b.category = :category")
    List<Book> getBooksByGivenCat(@Param("category") Category category);

    List<Book> findByAuthorList(Author author);

    List<Book> findByAuthorList_Id(Long id);

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByRating(int rating);

    Book findTopByCategoryOrderByTitle(Category category);

    @Query("SELECT b FROM Book b WHERE b.rating >= :minRating AND b.rating <= :maxRating")
    List<Book> getBooksBetweenRatings(@Param("minRating") int minRating, @Param("maxRating") int maxRating);

    List<Book> findAllByDescriptionIgnoringCaseContaining(String description);

}
