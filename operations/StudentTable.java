package org.SchoolManagement.operations;

import org.SchoolManagement.core.DbUtil;
import org.SchoolManagement.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentTable extends DbUtil {

    static DbUtil db = new DbUtil();
    static PreparedStatement PreparedStatement = null;

    public static List<Student> retrieveStudentFromDatabase() throws SQLException {
        Connection con = null;
        List<Student> studentList = new ArrayList<>();

        try {
            System.out.println("Connecting....");
            con = DriverManager.getConnection(db.returnConn(), db.returnUsername(), db.returnPassword());
            System.out.println("Connected");
            System.out.println("---");
            PreparedStatement = con.prepareStatement("SELECT * FROM students");

            ResultSet rs = PreparedStatement.executeQuery();

            while (rs.next()) {
                int studentId = rs.getInt(1);
                String studentName = rs.getString(2);
                int studentAge = rs.getInt(3);
                String studentGrade = rs.getString(4);

                Student student = new Student();
                student.setID(studentId);
                student.setName(studentName);
                student.setAge(studentAge);
                student.setGrade(studentGrade);

                studentList.add(student);
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return studentList;
    }

    public static void insertStudentsIntoDatabase(Student newStudent){
        try {
            Connection con = DriverManager.getConnection(db.returnConn(), db.returnUsername(), db.returnPassword());
            PreparedStatement = con.prepareStatement("INSERT INTO students (Name, Age, Grade) VALUES (?, ?, ?)");
            PreparedStatement.setString(1, newStudent.getName());
            PreparedStatement.setInt(2, newStudent.getAge());
            PreparedStatement.setString(3, newStudent.getGrade());
            System.out.println("Inserting students data.....");
            PreparedStatement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Data added!");
    }

    public static void manualAddToDatabase()
    {
        Student newStudent = new Student();
        System.out.println("Please enter the new students name: ");
        Scanner scan = new Scanner(System.in);
        String newName = scan.next();
        System.out.println("Please enter the new students age: ");
        int newAge = scan.nextInt();
        System.out.println("Please enter the new students grade: ");
        String newGrade = scan.next();

        newStudent.setName(newName);
        newStudent.setAge(newAge);
        newStudent.setGrade(newGrade);

        insertStudentsIntoDatabase(newStudent);
    }

    public static void removeFromDatabase(String studentId)
    {
        try {
            Connection con = DriverManager.getConnection(db.returnConn(), db.returnUsername(), db.returnPassword());
            PreparedStatement = con.prepareStatement("DELETE FROM students WHERE ID= ?");
            PreparedStatement.setString(1, studentId);
            System.out.println("Deleting students data.....");
            PreparedStatement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Student removed from database.");
    }
}
