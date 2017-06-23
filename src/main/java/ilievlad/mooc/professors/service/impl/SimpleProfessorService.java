package ilievlad.mooc.professors.service.impl;

import ilievlad.mooc.professors.model.Professor;
import ilievlad.mooc.professors.repository.ProfessorRepository;
import ilievlad.mooc.professors.service.ProfessorService;
import ilievlad.mooc.users.model.User;
import ilievlad.mooc.users.model.UserType;
import ilievlad.mooc.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Vlad on 22/06/2017.
 */
@Service
public class SimpleProfessorService implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    private UserService userService;

    @Autowired
    public SimpleProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public long getProfessor(String username, String password) {
        if (this.professorRepository.findByUsernameAndPasswordIn(username, password) != null) {
            long id = this.professorRepository.findByUsernameAndPasswordIn(username, password).getId();
            User user = new User();
            user.setUserId(id);
            user.setUserType(UserType.professor);
            user.setAccessDate(new Date());
            this.userService.saveUser(user);
            return id;
        }
        else return -1;
    }

    @Override
    public boolean saveProfessor(Professor professor) {
        if (this.professorRepository.save(professor) != null) return true;
        else return false;
    }

    @Override
    public String getProfessorUsername(long id) {
        return this.professorRepository.findOne(id).getUsername();
    }

}
