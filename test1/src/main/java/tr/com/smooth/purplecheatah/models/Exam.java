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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "Exam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e")
    , @NamedQuery(name = "Exam.findById", query = "SELECT e FROM Exam e WHERE e.id = :id")
    , @NamedQuery(name = "Exam.findByName", query = "SELECT e FROM Exam e WHERE e.name = :name")
    , @NamedQuery(name = "Exam.findBySemester", query = "SELECT e FROM Exam e WHERE e.semester = :semester")
    , @NamedQuery(name = "Exam.findBySHour", query = "SELECT e FROM Exam e WHERE e.sHour = :sHour")
    , @NamedQuery(name = "Exam.findByEHour", query = "SELECT e FROM Exam e WHERE e.eHour = :eHour")})
public class Exam implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentage")
    private Float percentage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exam")
    private Collection<ExamTaken> examTakenCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "semester")
    private String semester;
    @Basic(optional = false)
    @NotNull
    @Column(name = "s_hour")
    private int sHour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "e_hour")
    private String eHour;
    @ManyToMany(mappedBy = "examCollection")
    private Collection<Student> studentCollection;
    @JoinColumn(name = "lecture_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lecture lectureId;

    public Exam() {
    }

    public Exam(Integer id) {
        this.id = id;
    }

    public Exam(Integer id, String name, int sHour, String eHour) {
        this.id = id;
        this.name = name;
        this.sHour = sHour;
        this.eHour = eHour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getSHour() {
        return sHour;
    }

    public void setSHour(int sHour) {
        this.sHour = sHour;
    }

    public String getEHour() {
        return eHour;
    }

    public void setEHour(String eHour) {
        this.eHour = eHour;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public Lecture getLectureId() {
        return lectureId;
    }

    public void setLectureId(Lecture lectureId) {
        this.lectureId = lectureId;
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
        if (!(object instanceof Exam)) {
            return false;
        }
        Exam other = (Exam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.com.argela.test1.models.Exam[ id=" + id + " ]";
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    @XmlTransient
    public Collection<ExamTaken> getExamTakenCollection() {
        return examTakenCollection;
    }

    public void setExamTakenCollection(Collection<ExamTaken> examTakenCollection) {
        this.examTakenCollection = examTakenCollection;
    }
    
}
