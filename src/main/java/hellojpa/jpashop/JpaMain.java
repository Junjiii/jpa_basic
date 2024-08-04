package hellojpa.jpashop;

import hellojpa.jpashop.domain.Book;
import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try{
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("Kim");

            em.persist(book);
            tx.commit();
        }catch(Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
