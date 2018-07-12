/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.smooth.purplecheatah.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author omer
 */
@Entity
@Table(name = "Taken_Lecture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TakenLecture.findAll", query = "SELECT t FROM TakenLecture t")
    , @NamedQuery(name = "TakenLecture.findByStudentId", query = "SELECT t FROM TakenLecture t WHERE t.takenLecturePK.studentId = :studentId")
    , @NamedQuery(name = "TakenLecture.findByLectureId", query = "SELECT t FROM TakenLecture t WHERE t.takenLecturePK.lectureId = :lectureId")
    , @NamedQuery(name = "TakenLecture.findByGrade", query = "SELECT t FROM TakenLecture t WHERE t.grade = :grade")})
public class TakenLecture implements Serializable {

    @Size(max = 2)
    @Column(name = "grade")
    private String grade;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TakenLecturePK takenLecturePK;
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;
    @JoinColumn(name = "lecture_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Lecture lecture;

    public TakenLecture() {
    }

    public TakenLecture(TakenLecturePK takenLecturePK) {
        this.takenLecturePK = takenLecturePK;
    }

    public TakenLecture(TakenLecturePK takenLecturePK, String grade) {
        this.takenLecturePK = takenLecturePK;
        this.grade = grade;
    }

    public TakenLecture(int studentId, int lectureId) {
        this.takenLecturePK = new TakenLecturePK(studentId, lectureId);
    }

    public TakenLecturePK getTakenLecturePK() {
        return takenLecturePK;
    }

    public void setTakenLecturePK(TakenLecturePK takenLecturePK) {
        this.takenLecturePK = takenLecturePK;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (takenLecturePK != null ? takenLecturePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TakenLecture)) {
            return false;
        }
        TakenLecture other = (TakenLecture) object;
        if ((this.takenLecturePK == null && other.takenLecturePK != null) || (this.takenLecturePK != null && !this.takenLecturePK.equals(other.takenLecturePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.argela.test1.models.TakenLecture[ takenLecturePK=" + takenLecturePK + " ]";
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
}
