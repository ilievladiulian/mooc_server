package ilievlad.mooc.comments.repository;

import ilievlad.mooc.comments.model.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vlad on 20/06/2017.
 */
@Repository
public interface CommentsRepository extends CrudRepository<Comments, Long> {
    public List<Comments> findByChapterIdInOrderByCreatedAsc(long id);
}
