import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student st1 = new Student();
        st1.setS_age(5);
        st1.setS_name("removesameid");
        em.persist(st1);
        em.getTransaction().commit();
        System.out.println("st1 created and persisted: " + st1);

        em.getTransaction().begin();

        em.remove(st1);
        System.out.println(em.contains(st1));
        st1.setS_id(9999999);
        em.detach(st1);
        em.detach(st1);
        em.detach(st1);
        System.out.println(em.contains(st1));
        em.getTransaction().commit();
        em.detach(st1);
        System.out.println("st1: " + st1);

        em.close();
        emf.close();
    }
}
