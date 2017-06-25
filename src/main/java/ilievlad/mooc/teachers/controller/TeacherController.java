package ilievlad.mooc.teachers.controller;

import ilievlad.mooc.courses.model.Course;
import ilievlad.mooc.teachers.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vlad on 25/06/2017.
 */
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/teachers/list_courses/{professorId}", method = RequestMethod.GET)
    public List<Course> getCoursesByProfessorId(@PathVariable(value = "professorId") long professorId) {
        return this.teacherService.getCoursesByProfessorId(professorId);
    }
}
