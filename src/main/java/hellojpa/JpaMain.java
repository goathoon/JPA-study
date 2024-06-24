package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // persistence(자바 표준 JPA)의 설정정보가 담겨져 있는 META-INF/persistence.xml 파일에서 persistence-unit name을 불러옴
        // 추가적으로 EntityManagerFactory는 Spring 서버가 올라갈때, 딱 한번만 생성이 되어야할 것. 그 이후부터 EntityManager를 낳아서 Connection 진행
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // JPA는 필수로 하나의 트랜잭션이 필요하다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{

            Member findMember = em.find(Member.class, 1L);
            findMember.setName("수정된염소이름"); // 어떻게 변경될 수 있을까?
            /**
             * JPA를 통해 Entity를 가져오면 JPA가 관리를 진행.
             * 그 이후부터는 트랜잭션을 커밋하는 시점에 데이터가 변경되었는지 확인하고
             * 변경되었으면, update쿼리를 진행
             */
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            // Entity Manager는 내부적으로 Connection을 가지고 동작하기 때문에, close하지 않으면 connection 낭비이다.
            em.close();
        }

        em = emf.createEntityManager();
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        try{
            /**
             * 다음과 같이 JPQL방식으로 JPA를 사용하는데 쿼리를 작성할 수 있음
             * 다만 테이블에서 선택하는 것이 아니라 Member '클래스'를 기준으로 필드값을 가져오는 것을 확인할 수 있음.
             * 즉 "객체 지향 쿼리"
             */
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();
            for(Member m : result){
                System.out.println("member name = " + m.getName());
            }
            tx2.commit();
        }catch(Exception e){
            tx2.rollback();
        }finally{
            // Entity Manager는 내부적으로 Connection을 가지고 동작하기 때문에, close하지 않으면 connection 낭비이다.
            em.close();
        }
        emf.close();
    }
}
