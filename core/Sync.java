package org.SchoolManagement.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Sync extends DbUtil{
    static DbUtil db = new DbUtil();
    static PreparedStatement PreparedStatement = null;

    public static void PrepareDatabase()
    {
        try {
            Connection con = DriverManager.getConnection(db.returnConn(), db.returnUsername(), db.returnPassword());
            PreparedStatement = con.prepareStatement("DELETE FROM grades");
            PreparedStatement.executeUpdate();
            PreparedStatement = con.prepareStatement("Insert into grades (grades.Student,grades.Grade) Select Name,Grade from students");
            PreparedStatement.executeUpdate();
            PreparedStatement = con.prepareStatement("UPDATE grades JOIN teachers ON grades.Grade = teachers.Grade SET grades.Teacher = teachers.Name");
            PreparedStatement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
