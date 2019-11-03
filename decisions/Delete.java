package org.SchoolManagement.decisions;

import org.SchoolManagement.operations.StudentTable;
import org.SchoolManagement.operations.TeacherTable;

import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

    public static void RemoveDetails() throws SQLException {
        System.out.println("Type 1 to delete new Student details.");
        System.out.println("---");
        System.out.println("Type 2 to delete new Teacher details.");
        System.out.println("---");
        System.out.println("Type 3 to delete new Class details.");
        Scanner scan = new Scanner(System.in);
        String ans = scan.next();
        System.out.println("---");
        switch (ans.toLowerCase()) {
            case "1":
                System.out.println("Please enter the ID of the student you would like to delete.");
                System.out.println("---");
                String studentId= scan.next();
                StudentTable.removeFromDatabase(studentId);
                break;
            case "2":
                System.out.println("Please enter the ID of the teacher you would like to delete.");
                System.out.println("---");
                String teacherId= scan.next();
                TeacherTable.removeFromDatabase(teacherId);
                break;
        }
    }
}
