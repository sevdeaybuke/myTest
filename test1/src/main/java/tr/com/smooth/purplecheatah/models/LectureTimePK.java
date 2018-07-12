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
import javax.validation.constraints.Size;

/**
 *
 * @author omer
 */
@Embeddable
public class LectureTimePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "lecture_id")
    private int lectureId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "day")
    private String day;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "semester")
    private String semester;

    public LectureTimePK() {
    }

    public LectureTimePK(int lectureId, String day, String semester) {
        this.lectureId = lectureId;
        this.day = day;
        this.semester = semester;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) lectureId;
        hash += (day != null ? day.hashCode() : 0);
        hash += (semester != null ? semester.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LectureTimePK)) {
            return false;
        }
        LectureTimePK other = (LectureTimePK) object;
        if (this.lectureId != other.lectureId) {
            return false;
        }
        if ((this.day == null && other.day != null) || (this.day != null && !this.day.equals(other.day))) {
            return false;
        }
        if ((this.semester == null && other.semester != null) || (this.semester != null && !this.semester.equals(other.semester))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.argela.test1.models.LectureTimePK[ lectureId=" + lectureId + ", day=" + day + ", semester=" + semester + " ]";
    }
    
}
