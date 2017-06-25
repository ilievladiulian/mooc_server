package ilievlad.mooc.teachers.service.impl;

import ilievlad.mooc.courses.model.Course;
import ilievlad.mooc.courses.repository.CourseRepository;
import ilievlad.mooc.teachers.model.Teacher;
import ilievlad.mooc.teachers.repository.TeacherRepository;
import ilievlad.mooc.teachers.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 25/06/2017.
 */
@Service
public class SimpleTeacherService implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCoursesByProfessorId(long professorId) {
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers = this.teacherRepository.findByProfessorId(professorId);
        List<Course> courses = new ArrayList<Course>();
        for (int i = 0; i < teachers.size(); i++) {
            courses.add(this.courseRepository.findOne(teachers.get(i).getCourse().getId()));
        }
        return courses;
    }

    @Override
    public void deleteByCourseId(long courseId) {
        List<Teacher> teachers = (List<Teacher>) this.teacherRepository.findByCourseId(courseId);
        for (int i = 0; i < teachers.size(); i++) {
            this.teacherRepository.delete(teachers.get(i).getId());
        }
    }
}
