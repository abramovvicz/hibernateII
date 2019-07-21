package dao;

import connection.BookStoreEntityManagerFactory;
import model.Book;
import model.Category;
import model.CategoryCode;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CategoryDaoImp implements CategoryDao {
    @Override
    public Category findById(long id) {
        EntityManager entityManager = BookStoreEntityManagerFactory.ENTITY_MANAGER_FACTORY.createEntityManager();
        Category category = entityManager.find(Category.class, id);
        List<Book> booksList = category.getBooksList();
        entityManager.close();
        return category;
    }

    @Override
    public void insert(Category category) {
        EntityManager entityManager = BookStoreEntityManagerFactory.ENTITY_MANAGER_FACTORY.createEntityManager();

        entityManager.getTransaction().begin();//otwieranie transakcji
        entityManager.persist(category);   //zapisywanie kategorii
        entityManager.getTransaction().commit();  //komitowanie trasanckji


        entityManager.close();

    }

    @Override
    public List<String> findCategoryCodes() {
        EntityManager entityManager = BookStoreEntityManagerFactory.ENTITY_MANAGER_FACTORY.createEntityManager();
        Query query = entityManager.createQuery("select c.code from Category c");
        List resultList = query.getResultList();

        entityManager.close();
        return resultList;
    }

    @Override
    public Long findIdCategory(CategoryCode categoryCode) {
        EntityManager entityManager = BookStoreEntityManagerFactory.ENTITY_MANAGER_FACTORY.createEntityManager();
        //select id from bookstore14_jpa.categories where name = "Crime";
        Query query = entityManager.createQuery("select c.id from Category c where c.code = :categoryCode");
        query.setParameter("categoryCode", categoryCode);
        Long result = (Long) query.getSingleResult();
        entityManager.close();
        return result;
    }
}
