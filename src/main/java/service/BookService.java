package service;

import dto.BookDto;
import model.Book;
import model.CategoryCode;

import java.util.List;

public interface BookService {

    List<BookDto> findByTitle(String title);
    List<Book> findAllBooksByTitle(String title);
    long countBooksWithGivenCategoryCode(String categoryDao);

}
