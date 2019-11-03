package org.SchoolManagement.model;

import java.util.List;

public class Grade
{
    private int ID;
    private String grade;
    private String teacher;
    private List<Student> students;

    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Teacher: %s | Grade: %s | Student: %s", ID, grade, teacher, students);
    }
}
