package ilievlad.mooc.students.service.impl;

import ilievlad.mooc.courses.service.impl.SimpleCourseService;
import ilievlad.mooc.students.model.Student;
import ilievlad.mooc.students.repository.StudentRepository;
import ilievlad.mooc.students.service.StudentService;
import ilievlad.mooc.users.model.User;
import ilievlad.mooc.users.model.UserType;
import ilievlad.mooc.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Vlad on 19/06/2017.
 */
@Service
public class SimpleStudentService implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    public SimpleStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public long getStudent(String username, String password) {
        if (this.studentRepository.findByUsernameAndPassword(username, password) != null) {
            long id = this.studentRepository.findByUsernameAndPassword(username, password).getId();
            User user = new User();
            user.setUserId(id);
            user.setUserType(UserType.student);
            user.setAccessDate(new Date());
            this.userService.saveUser(user);
            return id;
        }
        else return -1;
    }

    @Override
    public boolean saveStudent(Student student) {
        if (this.studentRepository.save(student) != null) return true;
        else return false;
    }

    @Override
    public String getStudentUsername(long id) {
        return this.studentRepository.findOne(id).getUsername();
    }

}
