package ilievlad.mooc.courses.controller;

import ilievlad.mooc.courses.model.Course;
import ilievlad.mooc.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Vlad on 19/06/2017.
 */

@RestController
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/courses/list_courses", method = RequestMethod.GET)
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

}
