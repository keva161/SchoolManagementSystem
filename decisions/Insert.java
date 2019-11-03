package org.SchoolManagement.decisions;

import org.SchoolManagement.operations.StudentTable;
import org.SchoolManagement.operations.TeacherTable;
import org.SchoolManagement.model.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Insert {

    private static List<Student> studentResults;

    public static void InsertDatabaseDetails() throws SQLException {
        System.out.println("Type 1 to insert new Student details.");
        System.out.println("---");
        System.out.println("Type 2 to insert new Teacher details.");
        System.out.println("---");
        System.out.println("Type 3 to insert new Class details.");
        Scanner scan = new Scanner(System.in);
        String ans = scan.next();
        System.out.println("---");
        switch (ans.toLowerCase()) {
            case "1":
                System.out.println("Please enter the student to be added to the database.");
                System.out.println("---");
                StudentTable.manualAddToDatabase();
                break;
            case "2":
                System.out.println("Please enter the teacher to be added to the database.");
                System.out.println("---");
                TeacherTable.manualAddToDatabase();
                break;
        }
    }
}
