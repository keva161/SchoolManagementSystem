package org.SchoolManagement.operations;

import org.SchoolManagement.core.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeTable extends DbUtil {

    static DbUtil db = new DbUtil();
    static PreparedStatement PreparedStatement = null;

    public static List<String> retrieveGradeList() throws SQLException {
        Connection con = null;
        List grades = null;

        System.out.println("Please enter the grade your would like to see the number of: ");
        Scanner scan = new Scanner(System.in);
        String gradeAns = scan.next();

        try {
            con = DriverManager.getConnection(db.returnConn(), db.returnUsername(), db.returnPassword());
            PreparedStatement = con.prepareStatement(String.format("Select distinct Teacher from grades WHERE Grade = '%s'", gradeAns));
            ResultSet rs = PreparedStatement.executeQuery();

            while (rs.next()) {
                String gradeTeacher = rs.getString(1);

                grades = new ArrayList();
                grades.add(gradeTeacher);
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return grades;
    }
}
