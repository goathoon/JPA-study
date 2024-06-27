package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.join.SubMovie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-shop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            SubMovie movie = new SubMovie();
            movie.setName("영화이름");
            movie.setPrice(1000);
            movie.setActor("actor2");
            movie.setDirector("director1");
            em.persist(movie);

            em.flush();
            em.clear();

            SubMovie findMovie = em.find(SubMovie.class, movie.getId());

            tx.commit();
        } catch(Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
