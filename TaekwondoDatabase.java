package src;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jadon
 */
public class TaekwondoDatabase {

    Connection conn = null;
    String url = "jdbc:derby:TaekwondoDB;create=true";
    String dbUser = "admin";
    String dbPass = "admin";

    public void dbSetup() {
        try {
            conn = DriverManager.getConnection(url, dbUser, dbPass);
            Statement statement = conn.createStatement();
            String tableName = "studentDetails";

            if (!checkTableExisting(tableName) && !checkTableExisting("littleKiwi") && !checkTableExisting("tiger") && !checkTableExisting("dragon") && !checkTableExisting("adults") && !checkTableExisting("uniformList")) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (name VARCHAR(40), dateOfBirth VARCHAR(11), email VARCHAR(50), phone INT, belt VARCHAR(13), joiningDate VARCHAR(11))");
                statement.executeUpdate("CREATE TABLE littleKiwi (name VARCHAR (30))");
                statement.executeUpdate("CREATE TABLE dragon (name VARCHAR (30))");
                statement.executeUpdate("CREATE TABLE tiger (name VARCHAR (30))");
                statement.executeUpdate("CREATE TABLE adults (name VARCHAR (30))");
                statement.executeUpdate("CREATE TABLE uniformList (name VARCHAR (30), size INT)");
            } else {
                System.out.println("Tables exists");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    flag = true;
                }
            }
            rsDBMeta.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return flag;
    }

    public boolean checkName(String name) {
        boolean studentFound = false;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name FROM studentDetails WHERE name = '" + name.toUpperCase() + "'");
            if (rs.next()) {
                System.out.println("Student exists!");
                studentFound = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return studentFound;
    }

    public void saveStudent(String name, String dob, String email, int phone, String belt, String joiningDate, String chosenClass) {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO studentDetails VALUES('" + name.toUpperCase() + "','" + dob + "','" + email + "'," + phone + ",'" + belt + "','" + joiningDate + "')");
            statement.executeUpdate("INSERT INTO " + chosenClass + " VALUES('" + name.toUpperCase() + "')");
            System.out.println("Student added");
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void editStudent(String name, String detail, String newDetail) {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE studentDetails SET " + detail + "='" + newDetail + "' WHERE name ='" + name.toUpperCase() + "'");
            System.out.println("Student Edited");
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void removeStudent(String name) {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM studentDetails WHERE name ='" + name.toUpperCase() + "'");
            statement.executeUpdate("DELETE FROM littlekiwi WHERE name ='" + name.toUpperCase() + "'");
            statement.executeUpdate("DELETE FROM dragon WHERE name ='" + name.toUpperCase() + "'");
            statement.executeUpdate("DELETE FROM tiger WHERE name ='" + name.toUpperCase() + "'");
            statement.executeUpdate("DELETE FROM adults WHERE name ='" + name.toUpperCase() + "'");
            System.out.println("Student Deleted");
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ResultSet getClassList(String chosenClass) {
        ResultSet rs = null;
        Statement statement;
        try {
            System.out.println("Getting class");
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT name FROM "+chosenClass);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
    }

    public void addUniformOrder() {
    }

    public void deleteUniformOrder() {
    }
}
