package ilievlad.mooc.courses.service.impl;

import ilievlad.mooc.courses.model.Course;
import ilievlad.mooc.courses.repository.CourseRepository;
import ilievlad.mooc.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vlad on 19/06/2017.
 */
@Service
public class SimpleCourseService implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public SimpleCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getCourses() {
        List<Course> courseList = (List<Course>) this.courseRepository.findAll();
        return courseList;
    }
}
