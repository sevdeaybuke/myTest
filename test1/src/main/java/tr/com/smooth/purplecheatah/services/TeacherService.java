/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.smooth.purplecheatah.services;

import java.util.List;
import javax.persistence.EntityManager;
import tr.com.smooth.purplecheatah.dao.TeacherDao;
import tr.com.smooth.purplecheatah.models.Exam;
import tr.com.smooth.purplecheatah.models.Lecture;
import tr.com.smooth.purplecheatah.models.Student;
import tr.com.smooth.purplecheatah.models.Teacher;

/**
 *
 * @author omer
 */
public class TeacherService {

    TeacherDao dao = new TeacherDao();

    public List<Teacher> getTeachers(EntityManager em) {
        return dao.getTeacher(em);
    }

    public Teacher createTeacher(EntityManager em, Teacher teacher) {
        return dao.saveTeacher(em, teacher);
    }

    public void deleteTeacher(EntityManager em, String id) {
        dao.delete(em, id);
    }

    public boolean login(EntityManager em,String id, String pass) {
        return dao.login(em,id,pass);
    }

    public void setGrade(EntityManager em, String pass, int not, int sid) {
        dao.setGrade(em, pass, not, sid);
    }

    public Teacher showSelfTeacher(EntityManager em, String id) {
        return dao.showSelfTeachers(em,id);
    }
    public List<Lecture> getTeacherLectures(EntityManager em, String id) {
        return (List<Lecture>) dao.getTeacherLectures(em, id);

    }

    public List<Lecture> showTeacherLectures(EntityManager em, String id) {
        return (List<Lecture>) dao.showTeacherLectures(em, id);

    }   
    public void addExam(EntityManager em, String id, Exam exam){
        dao.addExam(em,id, exam);
    }

}
