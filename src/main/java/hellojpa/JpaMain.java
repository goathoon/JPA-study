package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // persistence(자바 표준 JPA)의 설정정보가 담겨져 있는 META-INF/persistence.xml 파일에서 persistence-unit name을 불러옴
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.close();

        emf.close();
    }
}
