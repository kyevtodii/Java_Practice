import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry)
                .getMetadataBuilder().build();

        try(SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

            Session session = sessionFactory.openSession()) {

            Course course = session.get(Course.class, 3);
            System.out.println("Course: " + course.getName() + " - " + course.getStudentsCount() + " students.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
