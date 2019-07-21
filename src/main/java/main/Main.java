package main;

import dao.BookDaoImp;
import dao.CategoryDaoImp;
import dao.CustomerDaoImp;
import dao.PublisherDao;
import dao.PublisherDaoImp;
import dto.BookDto;
import model.Address;
import model.Book;
import model.Category;
import model.CategoryCode;
import model.Customer;
import model.Sex;
import service.BookService;
import service.BookServiceImpl;
import service.CategoryService;
import service.CategoryServiceImp;
import service.CustomerService;
import service.CustomerServiceImp;
import service.PublisherService;
import service.PublisherServiceImp;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory =
//                Persistence.createEntityManagerFactory("bookstore14jpa");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//
//        Book book = entityManager.find(Book.class, 1L);  // argument 1 encja ktora przesuzkujemy a drugi to index
//        entityManager.close();


        BookService bookService = new BookServiceImpl(new BookDaoImp());
        List<BookDto> books = bookService.findByTitle("To");
        books.forEach(x -> System.out.println(x.getId() + " " + x.getTitle() + " " + x.getPagesNumber()));
        List<Book> allBooks = bookService.findAllBooksByTitle("To");
        allBooks.forEach(x -> System.out.println(x.getId() + " " + x.getTitle() + " " + x.getPagesNumber()));


        CategoryService categoryService = new CategoryServiceImp(new CategoryDaoImp());
        System.out.println(categoryService.findById(1L));

//        entityManagerFactory.close();

        Category category = new Category();
        category.setCode(CategoryCode.BIOGRAPHY);
        category.setName("Bio");
//        category.setCode(CategoryCode.HISTORY);
//        category.setName("History");
        categoryService.insert(category);

        Address address = new Address();
        address.setCity("Lodz");
        address.setZipCode("91495");
        address.setStreet("Some street");
        address.setStreetNo("123");

        Customer customer = new Customer();
        customer.setFirstName("Some name");
        customer.setLastName("Some last name");
        customer.setSex(Sex.M);
        customer.setCreateDate(LocalDateTime.now());
        customer.setAddress(address);
        CustomerService customerService = new CustomerServiceImp(new CustomerDaoImp());
        customerService.addCustomer(customer);

        PublisherService publisherService = new PublisherServiceImp(new PublisherDaoImp());
        publisherService.findByPublisherName("Wydawnictwo 1");


        System.out.println("id catetogry crime " + categoryService.findIdCategory(CategoryCode.CRIME));

        long i = bookService.countBooksWithGivenCategoryCode("CRIME");
        System.out.println(i);


    }
}
