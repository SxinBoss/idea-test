package me.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by merey on 2016-05-08.
 */
@TestAnnotation(name = "class",age = 21)
public class Test {
    String name="sxin";
    int age=20;

    @TestAnnotation(name = "name")
    public String getName(HttpServletRequest req, HttpServletResponse resp){
        return this.name;
    }
    @TestAnnotation(name = "age",age = 22)
    public int getAge(){
        return this.age;
    }
}
