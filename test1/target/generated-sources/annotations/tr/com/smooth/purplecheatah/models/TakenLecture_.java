package tr.com.smooth.purplecheatah.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tr.com.smooth.purplecheatah.models.Lecture;
import tr.com.smooth.purplecheatah.models.Student;
import tr.com.smooth.purplecheatah.models.TakenLecturePK;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-07-12T11:18:56")
@StaticMetamodel(TakenLecture.class)
public class TakenLecture_ { 

    public static volatile SingularAttribute<TakenLecture, TakenLecturePK> takenLecturePK;
    public static volatile SingularAttribute<TakenLecture, Student> student;
    public static volatile SingularAttribute<TakenLecture, String> grade;
    public static volatile SingularAttribute<TakenLecture, Lecture> lecture;

}