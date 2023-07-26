package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

public class Dao<T> {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<T> classe;
    static {
        try {
            emf = Persistence.createEntityManagerFactory("projetoJPA");
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public Dao() {
        this(null);
    }
    public Dao(Class<T> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }
    public Dao<T> openTransaction() {
        em.getTransaction().begin();
        return this;
    }
    public Dao<T> closeTransaction() {
        em.getTransaction().commit();
        return this;
    }
    public Dao<T> includeTransaction(T entity) {
        em.persist(entity);
        return this;
    }
    public Dao<T> includeAtomic(T entity) {
        return this.openTransaction().includeTransaction(entity).closeTransaction();
    }
    public T getById(Object id) {
        return em.find(classe, id);
    }
    public List<T> getAll() {
        return this.getAll(10, 0);
    }
    public List<T> getAll(int qnt, int displacement) {
        if (classe == null) {
            throw new UnsupportedOperationException("Class null");
        }
        String jpql = "select e from " + classe.getName() + " e";
        TypedQuery<T> query = em.createQuery(jpql, classe).setMaxResults(qnt)
                .setFirstResult(displacement);
        return query.getResultList();
    }
}
