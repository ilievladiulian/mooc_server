package ilievlad.mooc.participants.model;

import ilievlad.mooc.courses.model.Course;
import ilievlad.mooc.students.model.Student;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vlad on 18/06/2017.
 */
@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    private Date enrolled;

    private long grade;

    public Participant() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Date getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Date enrolled) {
        this.enrolled = enrolled;
    }

    public long getGrade() {
        return grade;
    }

    public void setGrade(long grade) {
        this.grade = grade;
    }
}
