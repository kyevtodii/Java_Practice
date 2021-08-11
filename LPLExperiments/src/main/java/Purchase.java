import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PurchaseList")
public class Purchase {

    @EmbeddedId
    private PurchaseId purchaseId;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
@Embeddable
class PurchaseId implements Serializable {

    @Column(name = "course_name")
    private String courseName;
    @Column(name = "student_name")
    private String studentName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public PurchaseId(String courseName, String studentName) {
        this.courseName = courseName;
        this.studentName = studentName;
    }

    public PurchaseId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseId that = (PurchaseId) o;
        return Objects.equals(courseName, that.courseName) &&
                Objects.equals(studentName, that.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, studentName);
    }
}
