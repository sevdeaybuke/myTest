package tr.com.smooth.purplecheatah.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tr.com.smooth.purplecheatah.models.Exam;
import tr.com.smooth.purplecheatah.models.ExamTakenPK;
import tr.com.smooth.purplecheatah.models.Student;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-07-12T11:18:56")
@StaticMetamodel(ExamTaken.class)
public class ExamTaken_ { 

    public static volatile SingularAttribute<ExamTaken, Exam> exam;
    public static volatile SingularAttribute<ExamTaken, Student> student;
    public static volatile SingularAttribute<ExamTaken, Float> grade;
    public static volatile SingularAttribute<ExamTaken, ExamTakenPK> examTakenPK;

}