package ilievlad.mooc.professors.repository;

import ilievlad.mooc.professors.model.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vlad on 22/06/2017.
 */
@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {

    Professor findByUsernameAndPasswordIn(String username, String password);

}
