package ilievlad.mooc.courses.repository;

import ilievlad.mooc.courses.model.Course;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Vlad on 19/06/2017.
 */

@Repository
@Transactional
public interface CourseRepository extends CrudRepository<Course, Long> {

    @Modifying
    @Query("update Course set title = ?1, description = ?2, start_date = ?4, end_date = ?5, max_number_of_days = ?3 where id = ?6")
    void setCourseById(String title, String description, int maxNumberOfDays, Date startDate, Date endDate, long courseId);

}
