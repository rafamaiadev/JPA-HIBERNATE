package basic.test;

import basic.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NewUser {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetoJPA");
        EntityManager em = emf.createEntityManager();

        User newuser = new User("silvana", "silvana@hotmail.com");

        em.getTransaction().begin();
        em.persist(newuser);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
