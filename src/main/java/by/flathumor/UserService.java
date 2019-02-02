package by.flathumor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class UserService
{
    private static final EntityManagerFactory emFactory;
    private static final String PERSISTENCE_UNIT_NAME = "auth-unit";

    static {
        emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }
}
