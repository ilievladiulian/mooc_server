package ilievlad.mooc.courses.controller;

import ilievlad.mooc.courses.model.Course;
import ilievlad.mooc.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/courses", method = RequestMethod.DELETE)
    public List<Course> deleteCourse(@RequestParam(value = "courseId") long courseId) {
        return this.courseService.deleteCourse(courseId);
    }

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/courses/{courseId}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable(value = "courseId") long courseId) {
        return this.courseService.getCourseById(courseId);
    }

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/courses/update_course", method = RequestMethod.PUT)
    public boolean updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }
}
