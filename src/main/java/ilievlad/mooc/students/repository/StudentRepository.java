package ilievlad.mooc.students.repository;

import ilievlad.mooc.students.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vlad on 19/06/2017.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

    Student findByUsernameAndPassword(String username, String password);

}
