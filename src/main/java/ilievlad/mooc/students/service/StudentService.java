package ilievlad.mooc.students.service;

import ilievlad.mooc.students.model.Student;

/**
 * Created by Vlad on 19/06/2017.
 */
public interface StudentService {

    long getStudent(String username, String password);
    boolean saveStudent(Student student);
    String getStudentUsername(long id);

}
