package tr.com.smooth.purplecheatah.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tr.com.smooth.purplecheatah.models.Exam;
import tr.com.smooth.purplecheatah.models.ExamTaken;
import tr.com.smooth.purplecheatah.models.TakenLecture;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-07-12T11:18:56")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> password;
    public static volatile SingularAttribute<Student, Integer> year;
    public static volatile CollectionAttribute<Student, ExamTaken> examTakenCollection;
    public static volatile SingularAttribute<Student, String> name;
    public static volatile CollectionAttribute<Student, TakenLecture> takenLectureCollection;
    public static volatile SingularAttribute<Student, Integer> id;
    public static volatile SingularAttribute<Student, String> email;
    public static volatile CollectionAttribute<Student, Exam> examCollection;

}