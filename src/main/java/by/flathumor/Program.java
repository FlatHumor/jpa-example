package by.flathumor;

import by.flathumor.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Program
{
    public static void main(String[] args)
    {
        EntityManager manager = UserService.getEntityManager();
        manager.getTransaction().begin();

        User user = new User();
        user.setIdentificator("lfkdfnvdnvlryt");
        user.setUsername("mark");
        user.setPassword("12345");
        manager.persist(user);
        manager.getTransaction().commit();

        Query query = manager.createNamedQuery("User.findAll");
        List<User> users = query.getResultList();
        for (User u : users)
            System.out.println("Username" + u.getUsername());
        manager.clear();

        System.out.println("Record Successfully Inserted In The Database");
    }
}
