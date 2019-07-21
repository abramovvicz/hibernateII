package dao;

import connection.BookStoreEntityManagerFactory;
import dto.BookDto;
import model.Book;
import model.CategoryCode;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BookDaoImp implements BookDao {
    @Override
    public List<BookDto> findByTitle(String title) {
        EntityManager entityManager = BookStoreEntityManagerFactory.ENTITY_MANAGER_FACTORY.createEntityManager();

        Query query = entityManager.createQuery("select new dto.BookDto(b.id, b.title, b.pagesNumber) from Book b where b.title = :bookTitle"); //JPQL
        // :title jak znak zapytania ?

        query.setParameter("bookTitle", title); //w miejsce booktitle z zapytania JPQL ustaw title
        List resultList = query.getResultList();
        entityManager.close();

//        entityManager.persist(); //zapisuje
//        entityManager.find(); // szuka
//        entityManager.merge()//aktualizacuje
//        entityManager.remove(); //usuwa

        return resultList;
    }

    @Override
    public List<Book> findAllBooksByTitle(String title) {
        EntityManager entityManager = BookStoreEntityManagerFactory.ENTITY_MANAGER_FACTORY.createEntityManager();

        Query query = entityManager.createQuery("select b from Book b where b.title = :bookTitle"); //JPQL
        // :title jak znak zapytania ?

        query.setParameter("bookTitle", title); //w miejsce booktitle z zapytania JPQL ustaw title
        List resultList = query.getResultList();
        entityManager.close();
        return resultList;

    }

    @Override  //metoda z entitymenagera
    public Book findById(long id) {
        EntityManager entityManager = BookStoreEntityManagerFactory.ENTITY_MANAGER_FACTORY.createEntityManager();
        Book book = entityManager.find(Book.class, id);

        entityManager.close();
        return book;
    }

    @Override
    public long countBooksWithGivenCategoryCode(String categoryCode) {
        EntityManager entityManager = BookStoreEntityManagerFactory.ENTITY_MANAGER_FACTORY.createEntityManager();
        //SQL select count(*) as "ilosc ksiazek" from books where category_id = 1;
        Query query = entityManager.createQuery("select count(b.id) from Book b inner join b.category c where c.code = :code");
//        Query query = entityManager.createQuery("select count(b.id) from Book b category.code where b.category.code = :code");

         CategoryDaoImp categoryDaoImp = new CategoryDaoImp();
//        Long idCategory = categoryDaoImp.findIdCategory(CategoryCode.CRIME);
        query.setParameter("code", CategoryCode.valueOf(categoryCode));
        long firstResult = (long) query.getSingleResult();
        entityManager.close();
        return firstResult;
    }
}
