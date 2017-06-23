package ilievlad.mooc.courses.repository;

import ilievlad.mooc.courses.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vlad on 19/06/2017.
 */

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}
