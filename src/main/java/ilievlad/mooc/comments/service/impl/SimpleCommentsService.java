package ilievlad.mooc.comments.service.impl;

import ilievlad.mooc.comments.model.Comments;
import ilievlad.mooc.comments.repository.CommentsRepository;
import ilievlad.mooc.comments.service.CommentsService;
import ilievlad.mooc.professors.service.ProfessorService;
import ilievlad.mooc.students.service.StudentService;
import ilievlad.mooc.comments_response.CommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 20/06/2017.
 */
@Service
public class SimpleCommentsService implements CommentsService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProfessorService professorService;

    private final CommentsRepository commentsRepository;

    @Autowired
    public SimpleCommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public List<CommentResponse> getCommentsForChapter(long id) {
        List<Comments> list = this.commentsRepository.findByChapterIdInOrderByCreatedDesc(id);
        List<CommentResponse> listCommentRespons = new ArrayList<CommentResponse>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProfessorId() == -1) {
                listCommentRespons.add(new CommentResponse(this.studentService.getStudentUsername(list.get(i).getStudentId()), "student", list.get(i)));
            } else {
                listCommentRespons.add(new CommentResponse(this.professorService.getProfessorUsername(list.get(i).getProfessorId()), "professor", list.get(i)));
            }
        }
        System.out.println(listCommentRespons);
        return listCommentRespons;
    }

}
