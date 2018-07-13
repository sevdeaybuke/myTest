/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.smooth.purplecheatah.dao;

// This is a DAO Class
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import tr.com.smooth.purplecheatah.models.Student;
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
}
//deneme