package org.SchoolManagement;
import org.SchoolManagement.core.Sync;
import org.SchoolManagement.decisions.Delete;
import org.SchoolManagement.decisions.Insert;
import org.SchoolManagement.decisions.Retrieve;

import java.sql.SQLException;
import java.util.Scanner;

public class main {


    public static void main(String[] args) throws SQLException {
        boolean looping = false;
        boolean firstRun = true;


        while (looping != true) {
            System.out.println("Connecting to the database.....");
            Sync.PrepareDatabase();
            System.out.println("Connected");
            System.out.println("---");

            System.out.println("Welcome to the School Management System");
            System.out.println("---");
            System.out.println("Press 1 to retrieve details, or 2 to insert new details");
            Scanner scan = new Scanner(System.in);
            String ans = scan.next();
            switch (ans.toLowerCase()) {
                case "1":
                    Retrieve.GetDatabaseDetails();
                    break;
                case "2":
                    Insert.InsertDatabaseDetails();
                    break;
                case "3":
                    Delete.RemoveDetails();
                    break;
                default:
                    System.out.println("Input not recognized");
                    System.out.println("---");
                    break;
            }
        }
    }
}

