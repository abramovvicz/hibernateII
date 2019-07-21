package service;

import dao.BookDao;
import dto.BookDto;
import model.Book;
import model.CategoryCode;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    //zasada depedency inversion nie uzależniac się od konkretnego obiektu a od wywołania konstruktora

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<BookDto> findByTitle(String title) {
        return bookDao.findByTitle(title);

    }

    @Override
    public List<Book> findAllBooksByTitle(String title) {
        return bookDao.findAllBooksByTitle(title);
    }

    @Override
    public long countBooksWithGivenCategoryCode(String categoryCode) {
        return bookDao.countBooksWithGivenCategoryCode(categoryCode);
    }


}
