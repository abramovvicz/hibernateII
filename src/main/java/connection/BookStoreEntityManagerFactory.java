package connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookStoreEntityManagerFactory {

    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("bookstore14jpa");
}
