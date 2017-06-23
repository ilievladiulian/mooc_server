package ilievlad.mooc.students.controller;

import ilievlad.mooc.students.model.Student;
import ilievlad.mooc.students.service.StudentService;
import ilievlad.mooc.users.model.User;
import ilievlad.mooc.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Vlad on 19/06/2017.
 */
@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/students/login", method = RequestMethod.POST)
    public long login(@RequestBody Student student) {
        return this.studentService.getStudent(student.getUsername(), student.getPassword());
    }

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/students/register", method = RequestMethod.POST)
    public boolean register(@RequestBody Student student) {
        return this.studentService.saveStudent(student);
    }

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public String getStudent(@PathVariable(value = "id") long id) {
        return this.studentService.getStudentUsername(id);
    }
}
