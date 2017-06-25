package ilievlad.mooc.teachers.model;

import ilievlad.mooc.courses.model.Course;
import ilievlad.mooc.professors.model.Professor;

import javax.persistence.*;

/**
 * Created by Vlad on 18/06/2017.
 */
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Course course;

    public Teacher() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
