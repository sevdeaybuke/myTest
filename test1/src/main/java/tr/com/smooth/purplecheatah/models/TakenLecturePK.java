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
public class TakenLecturePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "student_id")
    private int studentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lecture_id")
    private int lectureId;

    public TakenLecturePK() {
    }

    public TakenLecturePK(int studentId, int lectureId) {
        this.studentId = studentId;
        this.lectureId = lectureId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentId;
        hash += (int) lectureId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TakenLecturePK)) {
            return false;
        }
        TakenLecturePK other = (TakenLecturePK) object;
        if (this.studentId != other.studentId) {
            return false;
        }
        if (this.lectureId != other.lectureId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.argela.test1.models.TakenLecturePK[ studentId=" + studentId + ", lectureId=" + lectureId + " ]";
    }
    
}
