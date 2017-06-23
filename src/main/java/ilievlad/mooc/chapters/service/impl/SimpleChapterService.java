package ilievlad.mooc.chapters.service.impl;

import ilievlad.mooc.chapters.model.Chapter;
import ilievlad.mooc.chapters.repository.ChapterRepository;
import ilievlad.mooc.chapters.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vlad on 18/06/2017.
 */
@Service
public class SimpleChapterService implements ChapterService {

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

}
