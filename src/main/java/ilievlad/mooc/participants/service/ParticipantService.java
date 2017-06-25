package ilievlad.mooc.participants.service;

import ilievlad.mooc.courses.model.Course;

import java.util.List;

/**
 * Created by Vlad on 25/06/2017.
 */
public interface ParticipantService {

    public List<Course> getCoursesByStudentId(long studentId);
    public void deleteByCourseId(long courseId);

}
