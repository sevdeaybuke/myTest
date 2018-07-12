/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.smooth.purplecheatah.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author omer
 */
@Embeddable
public class ExamTakenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "student_id")
    private int studentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exam_id")
    private int examId;

    public ExamTakenPK() {
    }

    public ExamTakenPK(int studentId, int examId) {
        this.studentId = studentId;
        this.examId = examId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentId;
        hash += (int) examId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamTakenPK)) {
            return false;
        }
        ExamTakenPK other = (ExamTakenPK) object;
        if (this.studentId != other.studentId) {
            return false;
        }
        if (this.examId != other.examId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.smooth.purplecheatah.models.ExamTakenPK[ studentId=" + studentId + ", examId=" + examId + " ]";
    }
    
}
