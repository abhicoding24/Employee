package com.api;

public class Student {
    private long id;
    private String name;
    private long age;
    public Student(long id, String name, long age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public long getAge(){
        return age;
    }
}
