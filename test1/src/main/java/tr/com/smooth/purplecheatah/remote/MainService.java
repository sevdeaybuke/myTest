/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.smooth.purplecheatah.remote;

import java.util.List;
import javax.persistence.EntityManager;
import tr.com.smooth.purplecheatah.app.Application;
import tr.com.smooth.purplecheatah.models.Exam;
import tr.com.smooth.purplecheatah.models.Student;
import tr.com.smooth.purplecheatah.models.Teacher;
import tr.com.smooth.purplecheatah.services.StudentService;
import tr.com.smooth.purplecheatah.services.TeacherService;
import tr.com.smooth.purplecheatah.types.UserType;

/**
 *
 * @author aybuke
 */
public class MainService {

    StudentService studentService = new StudentService();
    TeacherService teacherService = new TeacherService();

    public List<Student> getStudents() throws Exception {
        EntityManager em = createSession();
        try {
            return studentService.getStudents(em);
        } catch (Exception e) {
            rollback(em);
            throw e;
        } finally {
            commit(em);
        }
    }

    public Student saveStudent(Student student) throws Exception {
        EntityManager em = createSession();
        try {
            return studentService.createStudent(em, student);
        } catch (Exception e) {
            rollback(em);
            throw e;
        } finally {
            commit(em);
        }
    }

    public void deleteStudent(String id) {
        EntityManager em = createSession();
        try {
            studentService.deleteStudent(em, id);
        } catch (Exception e) {
            rollback(em);
            throw e;
        } finally {
            commit(em);
        }
    }

    private void commit(EntityManager em) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
            em.getTransaction().begin();
        }
    }

    private EntityManager createSession() {
        EntityManager em = Application.getApp().getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        return em;
    }

    private void rollback(EntityManager em) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
            em.getTransaction().begin();
        }
    }

    public List<Teacher> getTeacher() {
        EntityManager em = createSession();
        try {
            return teacherService.getTeachers(em);
        } catch (Exception e) {
            rollback(em);
            throw e;
        } finally {
            commit(em);
        }
    }

    public Teacher saveTeacher(Teacher teacher) {
        EntityManager em = createSession();
        try {
            return teacherService.createTeacher(em, teacher);
        } catch (Exception e) {
            rollback(em);
            throw e;
        } finally {
            commit(em);
        }

    }

    public void deleteTeacher(String id) {
        EntityManager em = createSession();
        try {
            teacherService.deleteTeacher(em, id);
        } catch (Exception e) {
            rollback(em);
            throw e;
        } finally {
            commit(em);
        }

    }

    public Student searchStudent(String sid) {
        EntityManager em = createSession();
        try {
            return studentService.searchStudent(em, sid);
        } catch (Exception e) {
            rollback(em);
            throw e;
        } finally {
            commit(em);
        }
    }

    public UserType login(String id, String pass) {

        if (id.length() == 4 && studentLogin(id, pass)) {

            return UserType.STUDENT;

        } else {

            if (teacherLogin(id,pass)) {
                return UserType.TEACHER;
            } else {
                return UserType.INVALID;
            }
        }

    }

    public boolean studentLogin(String id, String pass) {
        EntityManager em = createSession();
        try {
            return studentService.login(em, id, pass);
        } catch (Exception e) {
            rollback(em);
            throw e;
        } finally {
            commit(em);
        }
    }

    public boolean teacherLogin(String id,String pass) {
        EntityManager em = createSession();
        try {
            return teacherService.login(em,id, pass);
        } catch (Exception e) {
            rollback(em);
            throw e;
        } finally {
            commit(em);
        }
    }

    public void setGrade(String pass, int sid, int not) {
        EntityManager em = createSession();
        try {
            teacherService.setGrade(em, pass, not, sid);
        } catch (Exception e) {
            rollback(em);
            throw e;
        } finally {
            commit(em);
        }
    }

    public Student showSelfInfo(String id) {
        EntityManager em = createSession();
        try {
            return studentService.showSelfInfo(em, id);
        } catch (Exception e) {
            rollback(em);
            throw e;
        } finally {
            commit(em);
        }

    }

    public Teacher showSelfTeacher(String id) {
        EntityManager em = createSession();
        try {
            return teacherService.showSelfTeacher(em, id);
        } catch (Exception e) {
            rollback(em);
            throw e;
        } finally {
            commit(em);
        }
    }

    public Exam showExamInfo(String id) {
        EntityManager em = createSession();
        try {
            return studentService.showExamInfo(em, id);
        } catch (Exception e) {
            rollback(em);
            throw e;
        } finally {
            commit(em);
        }
    }


}
