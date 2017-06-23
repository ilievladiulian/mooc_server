package ilievlad.mooc.comments.service.impl;

import ilievlad.mooc.chapters.model.Chapter;
import ilievlad.mooc.comments.model.Comments;
import ilievlad.mooc.comments.repository.CommentsRepository;
import ilievlad.mooc.comments.service.CommentsService;
import ilievlad.mooc.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Vlad on 20/06/2017.
 */
@Service
public class SimpleCommentsService implements CommentsService {

    private final CommentsRepository commentsRepository;

    @Autowired
    public SimpleCommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public List<Comments> getCommentsForChapter(long id) {
        List<Comments> list = this.commentsRepository.findByChapterIdInOrderByCreatedDesc(id);
        return list;
    }

}
