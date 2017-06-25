package ilievlad.mooc.teachers.repository;

import ilievlad.mooc.teachers.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vlad on 25/06/2017.
 */
@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    List<Teacher> findByProfessorId(long id);
    List<Teacher> findByCourseId(long id);
}
