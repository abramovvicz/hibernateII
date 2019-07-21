package dao;

import connection.BookStoreEntityManagerFactory;
import model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PublisherDaoImp implements PublisherDao {
    @Override
    public Publisher findByPublisherName(String publisherName) {
        EntityManager entityManager = BookStoreEntityManagerFactory.ENTITY_MANAGER_FACTORY.createEntityManager();
        Query query = entityManager.createQuery("select p from Publisher p where p.name = :name");
        query.setParameter("name", publisherName);

        Object singleResult = query.getSingleResult();

        entityManager.close();
        return (Publisher) singleResult;
    }
}
