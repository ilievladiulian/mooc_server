package ilievlad.mooc.comments.controller;

import ilievlad.mooc.comments.model.Comments;
import ilievlad.mooc.comments.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vlad on 20/06/2017.
 */
@RestController
public class CommentsController {

    private final CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/comments/list_comments", method = RequestMethod.GET)
    public List<Comments> getCommentsForChapter(@RequestParam(value = "chapter") long chapter_id) {
        return this.commentsService.getCommentsForChapter(chapter_id);
    }

}
