package org.SchoolManagement.decisions;

import org.SchoolManagement.operations.GradeTable;
import org.SchoolManagement.operations.StudentTable;
import org.SchoolManagement.operations.TeacherTable;
import org.SchoolManagement.model.Student;
import org.SchoolManagement.model.Teacher;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Retrieve {

    private static List<Student> studentResults;
    private static List<Teacher> teacherResults;
    private static List<String> gradeResults;

    public static List<Object> GetDatabaseDetails() throws SQLException {
        System.out.println("Type 1 to view Student details.");
        System.out.println("---");
        System.out.println("Type 2 to view Teacher details.");
        System.out.println("---");
        System.out.println("Type 3 to view Grade details by teacher.");
        Scanner scan = new Scanner(System.in);
        String ans = scan.next();
        System.out.println("---");
        switch (ans.toLowerCase()) {
            case "1":
                System.out.println("Retrieving student list.....");
                studentResults = StudentTable.retrieveStudentFromDatabase();
                for (Student student : studentResults) {
                    System.out.println("|" + student + "|");
                }
                if (studentResults.size() < 1) {
                    System.out.println("There are no students in the database.");
                    StudentTable.manualAddToDatabase();
                }
                break;
            case "2":
                System.out.println("Retrieving teacher list.....");
                teacherResults = TeacherTable.retrieveTeachersFromDatabase();
                for (Teacher teacher : teacherResults) {
                    System.out.println("|" + teacher + "|");
                }
                if (teacherResults.size() < 1) {
                    System.out.println("There are no teachers in the database.");
                    TeacherTable.manualAddToDatabase();
                }
                break;
            case "3":
                System.out.println("Retrieving list of grade teachers.....");
                gradeResults = GradeTable.retrieveGradeList();
                for (String gradeTeacher : gradeResults) {
                    System.out.println("|" + gradeTeacher + "|");
                }
                if (gradeResults.size() < 1) {
                    System.out.println("There are no teachers in the database for that grade. Please add one.");
                    TeacherTable.manualAddToDatabase();
                }
            default:
                System.out.println("Input not recognized");
                System.out.println("---");
                break;

        }
        return null;
    }
}
