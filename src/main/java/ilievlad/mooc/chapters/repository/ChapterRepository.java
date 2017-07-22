package ilievlad.mooc.chapters.repository;

import ilievlad.mooc.chapters.model.Chapter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vlad on 18/06/2017.
 */
@Repository
@Transactional
public interface ChapterRepository extends CrudRepository<Chapter, Long> {

    List<Chapter> findByCourseIdIn(long course);

    @Modifying
    @Query("update Chapter set title = ?1, content = ?2 where id = ?3")
    void updateChapter(String title, String content, long chapterId);

}
