package basic.test;

import basic.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetUser {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetoJPA");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 1L);
        //Serve para fazer uma consulta de um usuário.
        System.out.println(user.getName());

    }
}
