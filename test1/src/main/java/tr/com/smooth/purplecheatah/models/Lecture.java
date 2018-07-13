/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.smooth.purplecheatah.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author omer
 */
@Entity
@Table(name = "Lecture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecture.findAll", query = "SELECT l FROM Lecture l")
    , @NamedQuery(name = "Lecture.findById", query = "SELECT l FROM Lecture l WHERE l.id = :id")
    , @NamedQuery(name = "Lecture.findByLectureName", query = "SELECT l FROM Lecture l WHERE l.lectureName = :lectureName")
    , @NamedQuery(name = "Lecture.findByCredit", query = "SELECT l FROM Lecture l WHERE l.credit = :credit")})
public class Lecture implements Serializable {
    @Column(name = "t_id")
    private Integer tId;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "lecture_name")
    private String lectureName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credit")
    private float credit;
    @ManyToMany(mappedBy = "lectureCollection")
    private Collection<Teacher> teacherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lecture")
    private Collection<LectureTime> lectureTimeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lecture")
    private Collection<TakenLecture> takenLectureCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lectureId")
    private Collection<Exam> examCollection;

    public Lecture() {
    }

    public Lecture(Integer id) {
        this.id = id;
    }

    public Lecture(Integer id, String lectureName, float credit) {
        this.id = id;
        this.lectureName = lectureName;
        this.credit = credit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    @XmlTransient
    public Collection<Teacher> getTeacherCollection() {
        return teacherCollection;
    }

    public void setTeacherCollection(Collection<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
    }

    @XmlTransient
    public Collection<LectureTime> getLectureTimeCollection() {
        return lectureTimeCollection;
    }

    public void setLectureTimeCollection(Collection<LectureTime> lectureTimeCollection) {
        this.lectureTimeCollection = lectureTimeCollection;
    }

    @XmlTransient
    public Collection<TakenLecture> getTakenLectureCollection() {
        return takenLectureCollection;
    }

    public void setTakenLectureCollection(Collection<TakenLecture> takenLectureCollection) {
        this.takenLectureCollection = takenLectureCollection;
    }

    @XmlTransient
    public Collection<Exam> getExamCollection() {
        return examCollection;
    }

    public void setExamCollection(Collection<Exam> examCollection) {
        this.examCollection = examCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecture)) {
            return false;
        }
        Lecture other = (Lecture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.argela.test1.models.Lecture[ id=" + id + " ]";
    }

    public Integer getTId() {
        return tId;
    }

    public void setTId(Integer tId) {
        this.tId = tId;
    }
    
}
