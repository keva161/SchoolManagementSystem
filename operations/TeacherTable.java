package org.SchoolManagement.operations;

import org.SchoolManagement.core.DbUtil;
import org.SchoolManagement.model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherTable extends DbUtil {

    static DbUtil db = new DbUtil();
    static PreparedStatement PreparedStatement = null;

    public static List<Teacher> retrieveTeachersFromDatabase() throws SQLException {
        Connection con = null;
        Statement statement = null;
        List<Teacher> teacherList = new ArrayList<>();

        try {
            System.out.println("Connecting....");
            con = DriverManager.getConnection(db.returnConn(), db.returnUsername(), db.returnPassword());
            System.out.println("Connected");
            System.out.println("---");
            PreparedStatement = con.prepareStatement("SELECT * FROM teachers");
            ResultSet rs = PreparedStatement.executeQuery();

            while (rs.next()) {
                int teacherId = rs.getInt(1);
                String teacherName = rs.getString(2);
                String teacherGrade = rs.getString(3);
                int teacherSalary = rs.getInt(4);

                Teacher teacher = new Teacher();
                teacher.setID(teacherId);
                teacher.setName(teacherName);
                teacher.setGrade(teacherGrade);
                teacher.setSalary(teacherSalary);

                teacherList.add(teacher);
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return teacherList;
    }

    public static void insertStudentsIntoDatabase(Teacher newTeacher){
        try {
            Connection con = DriverManager.getConnection(db.returnConn(), db.returnUsername(), db.returnPassword());
            PreparedStatement = con.prepareStatement("INSERT INTO teachers (Name, Grade, Salary) VALUES (?, ?, ?)");
            PreparedStatement.setString(1, newTeacher.getName());
            PreparedStatement.setString(2, newTeacher.getGrade());
            PreparedStatement.setInt(3, newTeacher.getSalary());
            System.out.println("Inserting teacher data.....");
            PreparedStatement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Data added!");
    }

    public static void manualAddToDatabase()
    {
        try {
            Teacher newTeacher = new Teacher();
            System.out.println("Please enter the new teachers name: ");
            Scanner scan = new Scanner(System.in);
            String newName = scan.nextLine();
            System.out.println("Please enter the new teachers salary: ");
            int newSalary = scan.nextInt();
            System.out.println("Please enter the grade the teacher teaches: ");
            String newGrade = scan.next();


            newTeacher.setName(newName);
            newTeacher.setGrade(newGrade);
            newTeacher.setSalary(newSalary);

            insertStudentsIntoDatabase(newTeacher);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void removeFromDatabase(String teacherId)
    {
        try {
            Connection con = DriverManager.getConnection(db.returnConn(), db.returnUsername(), db.returnPassword());
            PreparedStatement = con.prepareStatement("DELETE FROM teachers WHERE ID= ?");
            PreparedStatement.setString(1, teacherId);
            System.out.println("Deleting teachers data.....");
            PreparedStatement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Teacher removed from database.");
    }
}
