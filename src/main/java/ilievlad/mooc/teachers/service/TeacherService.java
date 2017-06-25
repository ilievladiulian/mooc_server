package ilievlad.mooc.teachers.service;

import ilievlad.mooc.courses.model.Course;

import java.util.List;

/**
 * Created by Vlad on 25/06/2017.
 */
public interface TeacherService {

    public List<Course> getCoursesByProfessorId(long professorId);
    public void deleteByCourseId(long courseId);
}
