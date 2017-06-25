package ilievlad.mooc.participants.service.impl;

import ilievlad.mooc.courses.model.Course;
import ilievlad.mooc.courses.repository.CourseRepository;
import ilievlad.mooc.participants.model.Participant;
import ilievlad.mooc.participants.repository.ParticipantRepository;
import ilievlad.mooc.participants.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 25/06/2017.
 */
@Service
public class SimpleParticipantService implements ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCoursesByStudentId(long studentId) {
        List<Participant> participants = new ArrayList<Participant>();
        participants = this.participantRepository.findByStudentId(studentId);
        List<Course> courses = new ArrayList<Course>();
        for(int i = 0; i < participants.size(); i++) {
            courses.add(this.courseRepository.findOne(participants.get(i).getCourse().getId()));
        }
        return courses;
    }

    @Override
    public void deleteByCourseId(long courseId) {
        List<Participant> participants = (List<Participant>) this.participantRepository.findByCourseId(courseId);
        for (int i = 0; i < participants.size(); i++) {
            this.participantRepository.delete(participants.get(i).getId());
        }
    }
}
