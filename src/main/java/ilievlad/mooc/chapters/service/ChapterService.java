package ilievlad.mooc.chapters.service;

import ilievlad.mooc.chapters.model.Chapter;

import java.util.List;

/**
 * Created by Vlad on 18/06/2017.
 */
public interface ChapterService {
    List<Chapter> getChapters(long course);
    Chapter getChapter(long id);
    void deleteByCourseId(long courseId);
}
