package basic.test;

import basic.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ChangeUser3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetoJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        User user = em.find(User.class, 6L);
        em.detach(user);
        //Serve para tirar o objeto do estado gerenciado
        user.setName("Raphael");
        user.setEmail("rafamaia27@hotmail.com");

        //em.merge(user);
        //Serve para atualizar as modificações feitas
        em.getTransaction().commit();
    }
}
