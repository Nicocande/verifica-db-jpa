package it.tsp.control;

import it.tsp.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Store {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(Store.JPA_PU);
    private static EntityManager em = null;

    public static final String JPA_PU = "bookschool";

    static {
        System.out.println("create entity manager");
        em = emf.createEntityManager();
    }

    public static Book saveBook(Book b) {
        if (em.getTransaction().isActive()) {
            return em.merge(b);
        }
        em.getTransaction().begin();
        Book saved = em.merge(b);
        em.getTransaction().commit();
        return saved;

    }


    public static void removeBookbyID(int bookID) {
        if (em.getTransaction().isActive()) {
            return;
        }

        em.getTransaction().begin();
        em.remove(em.find(Book.class, bookID));
        em.getTransaction().commit();
        System.out.println(bookID);

    }

    public static void removeBook(Book b) {

        if (em.getTransaction().isActive()) {
           
        }
        em.getTransaction().begin();
        em.remove(b);
        em.getTransaction().commit();
      
    }

    public static void beginTran() {
        if (em.getTransaction().isActive()) {
            em.getTransaction();
        }
        em.getTransaction().begin();
    }

    public static void commitTran() {
        if (!em.getTransaction().isActive()) {
            throw new StoreException(" connection is alrrady close");
        }
        em.getTransaction().commit();
        ;
    }

    public static void rollTran() {
        if (!em.getTransaction().isActive()) {
            return;
        }
        em.getTransaction().rollback();
    }

}