package ilievlad.mooc.chapters.controller;

import ilievlad.mooc.chapters.model.Chapter;
import ilievlad.mooc.chapters.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vlad on 18/06/2017.
 */

@RestController
public class ChapterController {

    private final ChapterService chapterService;

    @Autowired
    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/chapters/list_chapters", method = RequestMethod.GET)
    public List<Chapter> getChapters(@RequestParam(value = "course") long course) {
        return this.chapterService.getChapters(course);
    }

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/chapters/{chapter}", method = RequestMethod.GET)
    public Chapter getChapter(@PathVariable(value = "chapter") long id) {
        return this.chapterService.getChapter(id);
    }

}
