package ilievlad.mooc.comments.model;

import ilievlad.mooc.chapters.model.Chapter;
import ilievlad.mooc.professors.model.Professor;
import ilievlad.mooc.students.model.Student;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vlad on 20/06/2017.
 */
@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private long studentId;
    private long professorId;

    @ManyToOne
    private Chapter chapter;

    @Lob
    private String description;

    private Date created;

    public Comments() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(long professorId) {
        this.professorId = professorId;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", professorId=" + professorId +
                ", chapter=" + chapter +
                ", description='" + description + '\'' +
                ", created=" + created +
                '}';
    }
}
