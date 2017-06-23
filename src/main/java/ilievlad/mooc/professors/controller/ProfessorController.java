package ilievlad.mooc.professors.controller;

import ilievlad.mooc.professors.model.Professor;
import ilievlad.mooc.professors.service.ProfessorService;
import ilievlad.mooc.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Vlad on 22/06/2017.
 */
@RestController
public class ProfessorController {

    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/professors/login", method = RequestMethod.POST)
    public long login(@RequestBody Professor professor) {
        return this.professorService.getProfessor(professor.getUsername(), professor.getPassword());
    }

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/professors/register", method = RequestMethod.POST)
    public boolean register(@RequestBody Professor professor) {
        return this.professorService.saveProfessor(professor);
    }

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/professors/{id}", method = RequestMethod.GET)
    public String getProfessor(@PathVariable(value = "id") long id) {
        return this.professorService.getProfessorUsername(id);
    }
}
