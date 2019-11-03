package org.SchoolManagement.model;

public class Student
{
    private int ID;
    private String name;
    private int age;
    private String grade;

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getName()
    {
        return this.name;
    }
    public int getAge()
    {
        return this.age;
    }
    public String getGrade()
    {
        return this.grade;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Age: %d | Grade: %s", ID, name, age, grade);
    }
}
