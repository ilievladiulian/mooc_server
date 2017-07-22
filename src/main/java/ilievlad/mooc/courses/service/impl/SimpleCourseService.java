package ilievlad.mooc.courses.service.impl;

import ilievlad.mooc.chapters.service.ChapterService;
import ilievlad.mooc.courses.model.Course;
import ilievlad.mooc.courses.repository.CourseRepository;
import ilievlad.mooc.courses.service.CourseService;
import ilievlad.mooc.participants.service.ParticipantService;
import ilievlad.mooc.teachers.repository.TeacherRepository;
import ilievlad.mooc.teachers.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vlad on 19/06/2017.
 */
@Service
public class SimpleCourseService implements CourseService {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private ParticipantService participantService;

    private final CourseRepository courseRepository;

    @Autowired
    public SimpleCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getCourses() {
        List<Course> courseList = (List<Course>) this.courseRepository.findAll();
        return courseList;
    }

    @Override
    public List<Course> deleteCourse(long courseId) {
        this.teacherService.deleteByCourseId(courseId);
        this.participantService.deleteByCourseId(courseId);
        this.chapterService.deleteByCourseId(courseId);
        this.courseRepository.delete(courseId);
        List<Course> courses = (List<Course>) this.courseRepository.findAll();
        return courses;
    }

    @Override
    public Course getCourseById(long courseId) {
        return this.courseRepository.findOne(courseId);
    }

    @Override
    public boolean updateCourse(Course course) {
        Course prevCourse = this.courseRepository.findOne(course.getId());
        this.courseRepository.setCourseById(course.getTitle(), course.getDescription(), course.getMaxNumberOfDays(), course.getStartDate(), course.getEndDate(), course.getId());
        return true;
    }
}
