package com.example.studentrecord;

import android.arch.lifecycle.ViewModel;

public class Student extends ViewModel {
    private int id;
    private String name;
    private String rollNumber;
    private String studentClass;
    private String father;
    private String mother;
    private String mobile;

    public Student() {

    }

    public Student(int id, String name, String rollNumber, String studentClass, String father, String mother, String mobile) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.studentClass = studentClass;
        this.father = father;
        this.mother = mother;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
