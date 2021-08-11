import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

    @EmbeddedId
    private SubscriptionId id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionsDate;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getSubscriptionsDate() {
        return subscriptionsDate;
    }

    public void setSubscriptionsDate(Date subscriptionsDate) {
        this.subscriptionsDate = subscriptionsDate;
    }
}
@Embeddable
class SubscriptionId implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        SubscriptionId that = (SubscriptionId) o;
        return studentId == that.studentId && courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}

