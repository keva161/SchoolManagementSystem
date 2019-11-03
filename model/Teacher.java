package org.SchoolManagement.model;

public class Teacher {

    private int ID;
    private String name;
    private String grade;
    private int salary;

    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getGrade() {
        return grade;
    }
    public int getSalary() {
        return salary;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Grade: %s | Salary: %d", ID, name, grade, salary);
    }
}
