package dao;

import connection.BookStoreEntityManagerFactory;
import model.Customer;

import javax.persistence.EntityManager;

public class CustomerDaoImp implements CustomerDao {

    @Override
    public void insert(Customer customer) {
        EntityManager entityManager = BookStoreEntityManagerFactory.ENTITY_MANAGER_FACTORY.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
