package ilievlad.mooc.chapters.service.impl;

import ilievlad.mooc.chapters.model.Chapter;
import ilievlad.mooc.chapters.repository.ChapterRepository;
import ilievlad.mooc.chapters.service.ChapterService;
import ilievlad.mooc.comments.model.Comments;
import ilievlad.mooc.comments.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vlad on 18/06/2017.
 */
@Service
public class SimpleChapterService implements ChapterService {

    @Autowired
    private CommentsRepository commentsRepository;

    private final ChapterRepository chapterRepository;

    @Autowired
    public SimpleChapterService(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @Override
    public List<Chapter> getChapters(long course) {
        List<Chapter> chapterList = (List<Chapter>) this.chapterRepository.findByCourseIdIn(course);
        return chapterList;
    }

    @Override
    public Chapter getChapter(long id) {
        return this.chapterRepository.findOne(id);
    }

    @Override
    public void deleteByCourseId(long courseId) {
        List<Chapter> chapters = (List<Chapter>) this.chapterRepository.findByCourseIdIn(courseId);
        for (int i = 0; i < chapters.size(); i++) {
            List<Comments> comments = (List<Comments>) this.commentsRepository.findByChapterIdInOrderByCreatedAsc(chapters.get(i).getId());
            for (int j = 0; j < comments.size(); j++) {
                this.commentsRepository.delete(comments.get(j).getId());
            }
            this.chapterRepository.delete(chapters.get(i).getId());
        }
    }

    @Override
    public boolean deleteByChapterId(long chapterId) {
        Chapter chapter = this.chapterRepository.findOne(chapterId);
        this.chapterRepository.delete(chapterId);
        List<Comments> comments = (List<Comments>) this.commentsRepository.findByChapterIdInOrderByCreatedAsc(chapterId);
        for (Comments comment : comments) {
            this.commentsRepository.delete(comment.getId());
        }
        List<Chapter> chapters = (List<Chapter>) this.chapterRepository.findAll();
        for (Chapter chap : chapters) {
            if (chapter.equals(chap)) return false;
        }
        return true;
    }

}
