import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListId id;

    public LinkedPurchaseListId getId() {
        return id;
    }

    public void setId(LinkedPurchaseListId id) {
        this.id = id;
    }
}
@Embeddable
class LinkedPurchaseListId implements Serializable {

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "student_id")
    private Integer studentId;

    public LinkedPurchaseListId() {
    }

    public LinkedPurchaseListId(Integer courseId, Integer studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        LinkedPurchaseListId id = (LinkedPurchaseListId) o;
        return Objects.equals(studentId, id.studentId) && Objects.equals(courseId, id.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}
