package basic.test;

import basic.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class getUsers {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetoJPA");
        EntityManager em = emf.createEntityManager();

        String jpql = "select u from User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class).setMaxResults(5);

        List<User> users = query.getResultList();

        for (User user : users) {
            System.out.println("ID: " + user.getId() + " E-mail: " + user.getEmail());
        }
    }
}
