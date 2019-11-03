package org.SchoolManagement.core;

public class DbUtil {
        private static String USERNAME = "admin";
        private static String PASSWORD = "password";
        private static String CONN = "jdbc:mysql://localhost/SchoolManagementSystem";

    public String returnUsername()
    {
        return USERNAME;
    }

    public String returnPassword()
    {
        return PASSWORD;
    }

    public String returnConn()
    {
        return CONN;
    }
}
