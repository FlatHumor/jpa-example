package by.flathumor;

import by.flathumor.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Program
{
    @SuppressWarnings("unchecked")
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

        Query query = manager.createNamedQuery("User.findAll", User.class);
        Query queryByUsername = manager.createNamedQuery("User.findByUsername", User.class);
        queryByUsername.setParameter("username", "mark");
        List<User> users = query.getResultList();
        for (User u : users)
            System.out.println("Username" + u.getUsername());
        manager.clear();

        System.out.println("Record Successfully Inserted In The Database");
    }
}
