/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.smooth.purplecheatah.models;

import java.io.Serializable;
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
@Table(name = "Lecture_Time")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LectureTime.findAll", query = "SELECT l FROM LectureTime l")
    , @NamedQuery(name = "LectureTime.findByLectureId", query = "SELECT l FROM LectureTime l WHERE l.lectureTimePK.lectureId = :lectureId")
    , @NamedQuery(name = "LectureTime.findByDay", query = "SELECT l FROM LectureTime l WHERE l.lectureTimePK.day = :day")
    , @NamedQuery(name = "LectureTime.findBySemester", query = "SELECT l FROM LectureTime l WHERE l.lectureTimePK.semester = :semester")})
public class LectureTime implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LectureTimePK lectureTimePK;
    @JoinColumn(name = "lecture_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Lecture lecture;

    public LectureTime() {
    }

    public LectureTime(LectureTimePK lectureTimePK) {
        this.lectureTimePK = lectureTimePK;
    }

    public LectureTime(int lectureId, String day, String semester) {
        this.lectureTimePK = new LectureTimePK(lectureId, day, semester);
    }

    public LectureTimePK getLectureTimePK() {
        return lectureTimePK;
    }

    public void setLectureTimePK(LectureTimePK lectureTimePK) {
        this.lectureTimePK = lectureTimePK;
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
        hash += (lectureTimePK != null ? lectureTimePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LectureTime)) {
            return false;
        }
        LectureTime other = (LectureTime) object;
        if ((this.lectureTimePK == null && other.lectureTimePK != null) || (this.lectureTimePK != null && !this.lectureTimePK.equals(other.lectureTimePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.argela.test1.models.LectureTime[ lectureTimePK=" + lectureTimePK + " ]";
    }
    
}
