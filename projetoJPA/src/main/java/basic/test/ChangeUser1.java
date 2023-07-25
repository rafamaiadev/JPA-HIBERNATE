package basic.test;

import basic.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ChangeUser1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetoJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        User user = em.find(User.class, 6L);
        user.setName("Raphael");
        user.setEmail("rafamaia27@hotmail.com");

        em.merge(user);

        em.getTransaction().commit();

    }
}
