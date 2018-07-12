package tr.com.smooth.purplecheatah.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tr.com.smooth.purplecheatah.models.Exam;
import tr.com.smooth.purplecheatah.models.LectureTime;
import tr.com.smooth.purplecheatah.models.TakenLecture;
import tr.com.smooth.purplecheatah.models.Teacher;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-07-12T11:18:56")
@StaticMetamodel(Lecture.class)
public class Lecture_ { 

    public static volatile SingularAttribute<Lecture, String> lectureName;
    public static volatile CollectionAttribute<Lecture, TakenLecture> takenLectureCollection;
    public static volatile CollectionAttribute<Lecture, LectureTime> lectureTimeCollection;
    public static volatile SingularAttribute<Lecture, Integer> id;
    public static volatile SingularAttribute<Lecture, Float> credit;
    public static volatile CollectionAttribute<Lecture, Teacher> teacherCollection;
    public static volatile CollectionAttribute<Lecture, Exam> examCollection;

}