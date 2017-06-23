package ilievlad.mooc.comments.service;

import ilievlad.mooc.comments.model.Comments;

import java.util.List;

/**
 * Created by Vlad on 20/06/2017.
 */
public interface CommentsService {
    public List<Comments> getCommentsForChapter(long id);
}
