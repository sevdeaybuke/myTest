package tr.com.smooth.purplecheatah.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tr.com.smooth.purplecheatah.models.Lecture;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-07-12T11:18:56")
@StaticMetamodel(Teacher.class)
public class Teacher_ { 

    public static volatile SingularAttribute<Teacher, String> password;
    public static volatile CollectionAttribute<Teacher, Lecture> lectureCollection;
    public static volatile SingularAttribute<Teacher, String> name;
    public static volatile SingularAttribute<Teacher, Integer> id;
    public static volatile SingularAttribute<Teacher, String> email;

}