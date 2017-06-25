package ilievlad.mooc.courses.service;

import ilievlad.mooc.courses.model.Course;

import java.util.List;

/**
 * Created by Vlad on 19/06/2017.
 */
public interface CourseService {
    List<Course> getCourses();
    List<Course> deleteCourse(long courseId);
}
