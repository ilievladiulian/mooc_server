package ilievlad.mooc.participants.controller;

import ilievlad.mooc.courses.model.Course;
import ilievlad.mooc.participants.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vlad on 25/06/2017.
 */
@RestController
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/participants/list_courses/{studentId}", method = RequestMethod.GET)
    public List<Course> getCourses(@PathVariable(value = "studentId") long studentId) {
        return participantService.getCoursesByStudentId(studentId);
    }
}
