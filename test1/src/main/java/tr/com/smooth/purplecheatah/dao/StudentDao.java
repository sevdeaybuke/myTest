/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.smooth.purplecheatah.dao;

// This is a DAO Class for students
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import tr.com.smooth.purplecheatah.models.Exam;
import tr.com.smooth.purplecheatah.models.Lecture;
import tr.com.smooth.purplecheatah.models.ExamTaken;
import tr.com.smooth.purplecheatah.models.ExamTakenPK;
import tr.com.smooth.purplecheatah.models.Student;
import tr.com.smooth.purplecheatah.models.TakenLecture;
import tr.com.smooth.purplecheatah.utilities.Utilities;

/**
 *
 * @author aybuke
 */
public class StudentDao {

    public List<Student> getStudents(EntityManager em) {
        Query query = em.createQuery("select s from Student s");
        return query.getResultList();
    }

    public Student save(EntityManager em, Student student) {
        Student saved = em.merge(student);
        em.flush();
        return saved;
    }

    public void delete(EntityManager em, String id) {
        Query query = em.createQuery("Delete from Student s where s.id = :id");
        int int_id =  Integer.parseInt(id);  
        query.setParameter("id",int_id);
        query.executeUpdate();
    }

    public Student searchStudent(EntityManager em, String sid) {
        Query query = em.createQuery("select s from Student s where s.id = :id");   
        int int_id =  Integer.parseInt(sid); 
        query.setParameter("id",int_id);
       
        return (Student) query.getSingleResult();
    }

    public boolean login(EntityManager em, String id, String pass) {
        
        Query query = em.createQuery("SELECT s FROM Student s WHERE s.id = :id and s.password = :password");
        
        query.setParameter("id",Integer.parseInt(id));
        query.setParameter("password",pass);
        
        return query.getResultList().size()==1;
    }

    

    public Student showSelfInfo(EntityManager em, String id) {
        Query query = em.createQuery("SELECT s FROM Student s WHERE s.id = :id");
        query.setParameter("id",Integer.parseInt(id));
        return (Student) query.getSingleResult();
        
    }

    public Exam showExamInfo(EntityManager em, String id) {
        Query query = em.createQuery("SELECT e , s  FROM ExamTaken , Exam  WHERE e.examTakenPK.studentId = :id and e.examTakenPK.examId=s.id");
        query.setParameter("id",Integer.parseInt(id));
        return (Exam) query.getSingleResult();
    }
    public List<Lecture> getLectures(EntityManager em) {
        Query query = em.createQuery("select s from Lecture s");
        return query.getResultList();
    }

    public List<Lecture> showLectures(EntityManager em) {
        Query query = em.createQuery("SELECT s FROM Lecture s");
        
        return (List<Lecture>) query.getResultList();
    }

   
    
    public List<ExamTaken> getExamGrades(EntityManager em, String id){
        Query query = em.createQuery("SELECT e FROM ExamTaken e where e.student.id = :id");
        query.setParameter("id", Integer.parseInt(id));
        return query.getResultList();
    }
    
    public List<TakenLecture> getLetterGrades(EntityManager em, String id){
        Query query = em.createQuery("SELECT e FROM TakenLecture e where e.student.id = :id");
        query.setParameter("id", Integer.parseInt(id));
        return query.getResultList();
    }
//conflict merge
//Pull request test
    
}
