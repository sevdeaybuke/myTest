package tr.com.smooth.purplecheatah.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tr.com.smooth.purplecheatah.models.ExamTaken;
import tr.com.smooth.purplecheatah.models.Lecture;
import tr.com.smooth.purplecheatah.models.Student;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-07-12T11:18:56")
@StaticMetamodel(Exam.class)
public class Exam_ { 

    public static volatile SingularAttribute<Exam, Integer> sHour;
    public static volatile SingularAttribute<Exam, Float> percentage;
    public static volatile CollectionAttribute<Exam, ExamTaken> examTakenCollection;
    public static volatile SingularAttribute<Exam, String> name;
    public static volatile SingularAttribute<Exam, String> eHour;
    public static volatile CollectionAttribute<Exam, Student> studentCollection;
    public static volatile SingularAttribute<Exam, String> semester;
    public static volatile SingularAttribute<Exam, Integer> id;
    public static volatile SingularAttribute<Exam, Lecture> lectureId;

}