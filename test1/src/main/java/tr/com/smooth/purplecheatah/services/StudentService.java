/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.smooth.purplecheatah.services;

import java.util.List;
import javax.persistence.EntityManager;
import tr.com.smooth.purplecheatah.dao.StudentDao;
import tr.com.smooth.purplecheatah.models.Lecture;
import tr.com.smooth.purplecheatah.models.Student;


public class StudentService {

    StudentDao dao = new StudentDao();
    

    public List<Student> getStudents(EntityManager em) {
        return dao.getStudents(em);
    }

    public Student createStudent(EntityManager em, Student student) {
        return dao.save(em, student);
    }

    public void deleteStudent(EntityManager em, String id) {
        dao.delete(em, id);
    }

    public Student searchStudent(EntityManager em, String sid) {
        return dao.searchStudent(em, sid);
    }

   

    public boolean login(EntityManager em, String id, String pass) {
        return dao.login(em,id, pass);
    }

    public Student showSelfInfo(EntityManager em , String id) {
        return dao.showSelfInfo(em,id);
    }
    
    public List<Lecture> getLectures(EntityManager em) {
        return dao.getLectures(em);
    }

    public List<Lecture> showLectures(EntityManager em) {
        return (List<Lecture>) dao.showLectures(em);

    }

   
}
