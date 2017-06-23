package ilievlad.mooc.chapters.repository;

import ilievlad.mooc.chapters.model.Chapter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vlad on 18/06/2017.
 */
@Repository
public interface ChapterRepository extends CrudRepository<Chapter, Long> {

    List<Chapter> findByCourseIdIn(long course);

}
