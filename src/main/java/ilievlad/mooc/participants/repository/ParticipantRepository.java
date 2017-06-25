package ilievlad.mooc.participants.repository;

import ilievlad.mooc.courses.model.Course;
import ilievlad.mooc.participants.model.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vlad on 25/06/2017.
 */
@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Long> {

    List<Participant> findByStudentId(long studentId);
    List<Participant> findByCourseId(long courseId);

}
