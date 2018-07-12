/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.smooth.purplecheatah.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author omer
 */
@Entity
@Table(name = "Exam_Taken")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamTaken.findAll", query = "SELECT e FROM ExamTaken e")
    , @NamedQuery(name = "ExamTaken.findByStudentId", query = "SELECT e FROM ExamTaken e WHERE e.examTakenPK.studentId = :studentId")
    , @NamedQuery(name = "ExamTaken.findByExamId", query = "SELECT e FROM ExamTaken e WHERE e.examTakenPK.examId = :examId")
    , @NamedQuery(name = "ExamTaken.findByGrade", query = "SELECT e FROM ExamTaken e WHERE e.grade = :grade")})
public class ExamTaken implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExamTakenPK examTakenPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "grade")
    private Float grade;
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;
    @JoinColumn(name = "exam_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Exam exam;

    public ExamTaken() {
    }

    public ExamTaken(ExamTakenPK examTakenPK) {
        this.examTakenPK = examTakenPK;
    }

    public ExamTaken(int studentId, int examId) {
        this.examTakenPK = new ExamTakenPK(studentId, examId);
    }

    public ExamTakenPK getExamTakenPK() {
        return examTakenPK;
    }

    public void setExamTakenPK(ExamTakenPK examTakenPK) {
        this.examTakenPK = examTakenPK;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examTakenPK != null ? examTakenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamTaken)) {
            return false;
        }
        ExamTaken other = (ExamTaken) object;
        if ((this.examTakenPK == null && other.examTakenPK != null) || (this.examTakenPK != null && !this.examTakenPK.equals(other.examTakenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.smooth.purplecheatah.models.ExamTaken[ examTakenPK=" + examTakenPK + " ]";
    }
    
}
