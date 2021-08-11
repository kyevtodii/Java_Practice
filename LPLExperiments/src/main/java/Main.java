import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry)
                .getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        String hql = "FROM " + LinkedPurchaseList.class.getSimpleName();
        List<LinkedPurchaseListId> purchaseList = session.createQuery(hql).getResultList();

        session.beginTransaction();

        for(LinkedPurchaseListId purchase : purchaseList) {
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Course> courseQuery = builder.createQuery(Course.class);
            Root<Course> courseRoot = courseQuery.from(Course.class);
            courseQuery.select(courseRoot).where(builder.equal(courseRoot.get("name"), purchase.getCourseId()));
            Course course = session.createQuery(courseQuery).getSingleResult();

            CriteriaQuery<Student> studentQuery = builder.createQuery(Student.class);
            Root<Student> studentRoot = studentQuery.from(Student.class);
            studentQuery.select(studentRoot).where(builder.equal(studentRoot.get("name"), purchase.getStudentId()));

            Student student = session.createQuery(studentQuery).getSingleResult();

            LinkedPurchaseListId linkedPurchaseList = new LinkedPurchaseListId();
            linkedPurchaseList.setCourseId(course.getId());
            linkedPurchaseList.setStudentId(student.getId());
            session.save(linkedPurchaseList);
        }
        session.getTransaction().commit();
        session.close();
        //sessionFactory.close();
    }
}
