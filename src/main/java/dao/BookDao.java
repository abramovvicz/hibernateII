package dao;

import dto.BookDto;
import model.Book;
import model.CategoryCode;

import java.util.List;

public interface BookDao {
    List<BookDto> findByTitle(String title);

    List<Book> findAllBooksByTitle(String title);

    Book findById(long id);

    long countBooksWithGivenCategoryCode(String categoryCode);



}
