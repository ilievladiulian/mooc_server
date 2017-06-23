package ilievlad.mooc.professors.service;

import ilievlad.mooc.professors.model.Professor;

/**
 * Created by Vlad on 22/06/2017.
 */
public interface ProfessorService {

    long getProfessor(String username, String password);
    boolean saveProfessor(Professor professor);
    String getProfessorUsername(long id);

}
