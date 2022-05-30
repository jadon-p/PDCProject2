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
                statement.executeUpdate("CREATE TABLE " + tableName + " (studentID INT, name VARCHAR(30), dateOfBirth VARCHAR(10), email VARCHAR(30), phone INT, belt VARCHAR(12))");
                statement.executeUpdate("CREATE TABLE littleKiwi (name VARCHAR (30))");
                statement.executeUpdate("CREATE TABLE tiger (name VARCHAR (30))");
                statement.executeUpdate("CREATE TABLE dragon (name VARCHAR (30))");
                statement.executeUpdate("CREATE TABLE adults (name VARCHAR (30))");
                statement.executeUpdate("CREATE TABLE uniformList (name VARCHAR (30), size INT)");
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
            ResultSet rs = statement.executeQuery("SELECT name FROM studentDetails" + "WHERE name = '" + name + "'");
            if (rs.next()) {
                System.out.println("Student already exists!");
                studentFound = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return studentFound;
    }

    public void saveStudent() {
    }

    public void removeStudent() {
    }

    public void addUniformOrder() {
    }

    public void deleteUniformOrder() {
    }
}
