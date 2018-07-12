/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author omer
 */
public class test {

    public static void main(String[] args) throws Exception{
        Map<UserType, List<Method>> methodMapByUser = new HashMap();

        Method methods[] = test.class.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            

            for (Annotation annotation : annotations) {
                if(annotation == null){
                    continue;
                }
                String annoType = annotation.annotationType().getSimpleName();
                UserType userType = UserType.valueOf(annoType);
                List<Method> lclmethods = methodMapByUser.get(userType);
                if (lclmethods == null) {
                    lclmethods = new ArrayList();
                    methodMapByUser.put(userType, lclmethods);
                }
                lclmethods.add(method);
            }
        }

        Map<Integer,Method> methodsById = new HashMap();
        int id = 1;
        for (UserType userType : methodMapByUser.keySet()) {
            System.out.println(userType);
            for (Method method : methodMapByUser.get(userType)) {
                methodsById.put(id, method);
                System.out.println(id +" -) "+method.getName());
                id++;
            }
        }
        
        int readCode = 2;
        
        test test = new test();
        Method callMethod = methodsById.get(readCode);
        callMethod.invoke(test, new Object[]{});

    }

    @Student()
    public void showStudent() {
        System.out.println("showStudent");
    }

    @Teacher()
    public void showTeacher() {
        System.out.println("showTeacher");
    }

    @Student()
    @Teacher()
    public void showLectures() {
        System.out.println("showLectures nebi test abc der123");
    }

}

enum UserType {
    Student,
    Teacher;
}
