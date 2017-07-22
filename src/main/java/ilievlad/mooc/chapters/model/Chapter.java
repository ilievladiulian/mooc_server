package ilievlad.mooc.chapters.model;

import ilievlad.mooc.courses.model.Course;

import javax.persistence.*;

/**
 * Created by Vlad on 18/06/2017.
 */
@Entity
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Course course;

    private String title;
    @Lob
    private String content;

    public Chapter() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof Chapter)) return false;
        else {
            if (!((Chapter) object).getContent().equals(this.getContent())) return false;
            if (!((Chapter) object).getCourse().equals(this.getCourse())) return false;
            if (!((Chapter) object).getTitle().equals((this.getTitle()))) return false;
        }
        return true;
    }
}
