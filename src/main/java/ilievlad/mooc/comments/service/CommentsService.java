package ilievlad.mooc.comments.service;

import ilievlad.mooc.comments_response.CommentResponse;

import java.util.List;

/**
 * Created by Vlad on 20/06/2017.
 */
public interface CommentsService {
    public List<CommentResponse> getCommentsForChapter(long id);
}
