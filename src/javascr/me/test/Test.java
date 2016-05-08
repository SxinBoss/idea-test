package me.test;

/**
 * Created by merey on 2016-05-08.
 */
@TestAnnotation(name = "class",age = 21)
public class Test {
    String name="sxin";
    int age=20;

    @TestAnnotation(name = "name")
    public String getName(){
        return this.name;
    }
    @TestAnnotation(name = "age",age = 22)
    public int getAge(){
        return this.age;
    }
}
